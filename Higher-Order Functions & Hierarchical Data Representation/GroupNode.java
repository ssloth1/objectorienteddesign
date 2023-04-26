/*
 * James Bebarski
 * GroupNode.java
 * Concept 4 + 5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * GroupNode is a generic class and child of AbstractTreeNode.
 * This node represents a non-leaf node, containing data along with the of other TreeNode elements as its children.
 * @param <T> The type of data that is stored in the GroupNode.
 */
public class GroupNode<T> extends AbstractTreeNode<T> {
	
	/** List to store the child nodes of the GroupNode.*/
	protected List<TreeNode<T>> children; 
	
	/**
	 * Constructor for creating a GroupNode with the given data. 
	 * @param data - The data of the GroupNode.
	 */
	public GroupNode(T data) {
		super(data);
		this.children = new ArrayList<TreeNode<T>>();
	}
	
	/**
	 * Constructor for creating a GroupNode with the given data and a list of children.
	 * @param data - The data of the GroupNode.
	 * @param children - The list of the TreeNode children.
	 */
	public GroupNode(T data, List<TreeNode<T>> children) {
		super(data);
		this.children = children;
	}
	
	/**
	 * Getter method for accessing a TreeNode's children.
	 * @return the TreeNode's children.
	 */
	public List<TreeNode<T>> getChildren() {
		return this.children;
	}
	
	/**
	 * Adds a child node to the tree if the given predicate matches the data. 
	 * @param identifier - A predicate that tests whether the given data should be added as a child.
	 * @param child - The child TreeNode to be added.
	 * @return The updated TreeNode after adding the child.
	 */
	public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
		if (identifier.test(this.data)) {
			this.children.add(child); // Add the child to this node.
			return this;
		}
		for (int i = 0; i < this.children.size(); i++) {
			//Add child and mutate the child
			this.children.set(i, this.children.get(i).addChild(identifier, child));
		}
		return this;
	}
	
	/**
	 * Returns a list of data in the tree.
	 * @return A list containing the data of all nodes in the tree. 
	 */
	@Override
	public List<T> toList() {
		List<T> result = new ArrayList<T>(); // Create a new list to store all tree nodes.
		result.add(this.data); // Add the current node's data to the result list.
		for (TreeNode<T> child: children) { // Iterate through each of the children in the current node.
		  result.addAll(child.toList()); // Add the data to to the result list.
		}
		return result; // Return the complete list of all data from all nodes.
	}
	
	/**
	 * Produces a tree with an identical structure but with data of the specified return type.
	 * @param <R> - The type of the resulting data.
	 * @param transform - maps the data in this tree to the data in the returned tree.
	 * @return The root of the corresponding mapped tree. 
	 */
	@Override
	public <R> TreeNode<R> map(Function<T,R> transform) {
		// Create a new GroupNode with the transformed data of the current node
		GroupNode<R> newNode = new GroupNode<>(transform.apply(this.data));
		// Iterate through the children of the current node.
		for (TreeNode<T> child:children) {
			// Map each child using the transform function and add the result to the new node.
			newNode.children.add(child.map(transform));
		}
		return newNode;
	}
	
	/**
	 * Reduces the data in the tree using the given combiner and initial value.
	 * @param initialValue - The initial value for the reduction operation.
	 * @param combiner - The A BiFunction that combines two values of the same type.
	 * @return The result of the reduction operation on the tree node.
	 */
	@Override
	public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
		// First, apply the combiner to the current node's data and the initial value
		T result = combiner.apply(initialValue, this.data);
		// For each child node, perform the reduce operation using recursion
    	// and combine the result with the current node's result.
		for (TreeNode<T> child : children) {
			result = child.reduce(result, combiner);
		}
		// Return the result obtained from the reduction.
		return result;
	}
	
	/**
	 * Traverses the tree using the a provided BiConsumer.
	 * @param visitor - A BiConsumer that processes the TreeNode and the depth of the node.
	 */
	@Override
	public void traverse(BiConsumer<TreeNode<T>, Integer> visitor) {
	    traverse(visitor, 0);
	}
	
	/**
	 * Helper method for the traverse method. 
	 * This method traverses the tree recursively, and applys the visitor BiConsumer to each node.
	 * @param visitor - A BiConsumer that processes the TreeNode and the depth of the node.
	 * @param depth - The current depth of the node in the tree structure.
	 */
	private void traverse(BiConsumer<TreeNode<T>, Integer> visitor, int depth) {
	    visitor.accept(this, depth); // Apply the visitor to the current node and its depth.
	    
	    // Iterate through all the child nodes.
	    for (TreeNode<T> child : children) {
	        if (child instanceof GroupNode) { // If the child node is an instance of GroupNode, perform a recursive traverse.
	            ((GroupNode<T>) child).traverse(visitor, depth + 1);
	        } else {
	        	// If the child node is not an instance of GroupNode, apply the visitor to the child and its depth.
	            visitor.accept(child, depth + 1);
	        }
	    }
	}
	
	/**
	 * This method prints the tree structure displaying each node's data. 
	 */
	@Override
	public void print() {
		System.out.println(data);
		for (TreeNode<T> child : children) { // For each child of children
			child.print(); // Recursively print child nodes
		}
	}   
}
