/*
 * James Bebarski
 * AbstractTreeNode.java
 * Concept 4 + 5
 */

/**
 * AbstractTreeNode is an abstract implementation of the TreeNode interface.
 * It provides a basic structure for a tree node, including the data of the node. 
 * @param <T> data is the type of data that will be stored in the node.
 */
public abstract class AbstractTreeNode<T> implements TreeNode<T> {
	
	/** The data to be stored in this node.*/
	protected T data; 
	
	/**
	 * AbstractTreeNode constructor, uses given data. 
	 * @param data the data to be kept in the node.
	 */
	public AbstractTreeNode(T data) {
		this.data = data;
	}
	
	@Override
	public T getData() {
	    return data;
	}
}
