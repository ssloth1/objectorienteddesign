/*
 * James Bebarski
 * LeafNode.java
 * Concept 4 + 5
 */

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * LeafNode is a generic class and child of AbstractTreeNode.
 * This node represents a leaf in the tree structure, containing a single data element.
 * @param <T> - The data of of the LeafNode.
 */
public class LeafNode<T> extends AbstractTreeNode<T> {
	
	/**
	 * Constructor for creating a LeafNode with the given data.
	 * @param data - The data of the LeafNode.
	 */
	public LeafNode(T data) {
		super(data);
	}
	
	/**
	 * Adds a child node to the tree if the given predicate matches the data.
	 * If the predicate matches, the LeafNode is promoted to a GroupNode and adds the child.
	 *  @param identifier - A predicate that tests whether the given data should be added as a child.
	 *  @param child - The child TreeNode to be added. 
	 *  @return The updated TreeNode after adding the child.
	 */
	@Override
	public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
		if (identifier.test(data)) {
			// promote this to a group tree node
			GroupNode<T> newNode = new GroupNode<T>(this.data);
			// Add the child to the new GroupNode
			newNode.addChild(identifier, child);
			return newNode; // Return the new GroupNode
		}
		return this; 
	}

	/**
	 * Returns a list of data in the tree.
	 * @return A list containing the data of this node.
	 */
	@Override
	public List<T> toList() {
		return List.of(data);
	}
	
	/**
	 * Produces a tree with an identical structure but with data of the specified return type.
	 * @param <R> - The type of the resulting data.
	 * @param transform - maps the data in this tree to the data in the returned tree.
	 * @return The root of the corresponding mapped tree. 
	 */
	@Override
	public <R> TreeNode<R> map(Function<T,R> transform) {
		return new LeafNode<R>(transform.apply(this.data));
	}
	
	/**
	 * Reduces the data in the tree using the given combiner and initial value.
	 * @param initialValue - The initial value for the reduction operation.
	 * @param combiner - The A BiFunction that combines two values of the same type.
	 * @return The result of the reduction operation on the tree node.
	 */
	@Override
	public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
		return combiner.apply(initialValue,this.data);
	}
	
	/**
	 *  Applies a visitor function to this node.
	 *  @param visitor - A BiConsumer that takes a TreeNode and its depth as arguments.
	 */
	@Override
	public void traverse(BiConsumer<TreeNode<T>, Integer> visitor) {
	    // Since this is a leaf node, the depth is always going to be 0.
		visitor.accept(this, 0);
	}
	
	/**
	 * Prints the data in the leaf node. 
	 */
	@Override
	public void print() {
		System.out.println(data);
	}
}
