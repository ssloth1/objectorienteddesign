/*
 * James Bebarski
 * TreeNode.java
 * Concept 4 + 5
 */

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * TreeNode is a generic interface for tree nodes.
 * It provides methods for manipulating and traversing the tree structure.
 * @param <T> The type of data stored in a tree node.
 */
 public interface TreeNode<T> {
	 
	 /**
	  * Retrieves the data stored in the current tree node.
	  * @return The data of type T stored in the node.
	  */
	 T getData();
	
	/**
	 * Adds a child node to the tree if the given predicate matches the data.
	 * @param identifier - A predicate that tests if the given data should be added as a child.
	 * @param child - The child TreeNode to be added.
	 * @return The updated TreeNode after adding the child. 
	 */
	TreeNode <T> addChild(Predicate <T> identifier, TreeNode<T> child);
	
	/**
	 * Returns a list of data in the tree. 
	 * @return A list containing the data of all nodes in the tree.
	 */
	List <T> toList();
	
	/**
	 * Produces a tree with an identical structure but with data of the specified return type.
	 * @param <R> - The type of the resulting data.
	 * @param transform - maps the data in this tree to the data in the returned tree.
	 * @return The root of the newly mapped tree. 
	 */
	<R> TreeNode <R> map(Function <T, R> transform);
	
	/**
	 * Reduces the data in the tree using the given combiner and initial value.
	 * @param initialValue - The initial value for the reduction operation.
	 * @param combiner - The A BiFunction that combines two values of the same type.
	 * @return The result of the reduction operation on the tree node.
	 */
	T reduce(T initialValue, BiFunction<T,T,T> combiner);
	
	/**
	 * Traverses the tree and calls the given visitor function for each each node in the tree.
	 * The visitor function is passed the current node and the depth of the node in the tree.
	 * @param visitor - A BiConsumer function that takes a TreeNode<T> and an Integer which represents the depth (level). 
	 */
	void traverse(BiConsumer<TreeNode <T>, Integer> visitor);
	
	/**
	 * Prints the tree structure.
	 */
	public void print();

}
 
