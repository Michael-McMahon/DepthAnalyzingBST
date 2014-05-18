package bst;
/**
 * Represents a node in a binary tree.
 * @author Michael McMahon
 *
 * @param <T> The type of object which this node will hold.
 */
public class Node<T> {
	//The value stored by this node 
	public T value;
	
	//The left subtree of this node
	public Node<T> leftChild;
	
	//The right subtree of this node
	public Node<T> rightChild;
	
	/**
	 * Creates a new node with the specified value.
	 * @param value
	 */
	public Node(T value)
	{
		this.value = value;
	}
}
