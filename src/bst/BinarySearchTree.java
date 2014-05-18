package bst;
import java.util.ArrayList;

/**
 * A basic binary search tree which stores values in a sorted order. The 
 * root’s left children store values less than the root’s value, and the root’s 
 * right children store values greater than or equal to the root’s value. 
 * Values can be any object type which implements the Comparable interface, 
 * such as Float.
 * @author Michael McMahon
 *
 * @param <T> Type of object which this tree will store. Must implement Comparable.
 */
public class BinarySearchTree<T extends Comparable<T>> {
	protected Node<T> topRoot;
	
	/**
	 * Insert a new value into this tree.
	 * @param value The value to insert.
	 */
	public void insert(T value)
	{
		//Null values are not allowed
		if(value == null)
		{
			return;
		}
		
		//Special case if this tree is empty
		if(topRoot == null)
		{
			//Create a new top root
			topRoot = new Node<T>(value);
		}
		//For non-empty tree, traverse starting at topRoot
		else
		{
			addLeaf(topRoot, value);
		}
	}
	
	/**
	 * Recursively traverses the tree, adding a new leaf such that all left 
	 * children of root have a value less than or equal to root’s value, and 
	 * all right children have a value greater than root’s value.
	 * @param root Node under which a new leaf will be created.
	 * @param value Value assigned to the new leaf.
	 */
	private void addLeaf(Node<T> root, T value)
	{
		Node<T> newNode;
		
		//If new value is greater than or equal to root's value
		if(value.compareTo(root.value) >= 0)
		{
			//If root's rightChild is null
			if(root.rightChild == null)
			{
				//Create new node with value
				newNode = new Node<T>(value);
				//Store new node as root's rightChild
				root.rightChild = newNode;
			}
			//If root's rightChild is not null
			else
			{
				addLeaf(root.rightChild, value);
			}
		}
		//If new value is less to root's value
		else
		{
			//If root's leftChild is null
			if(root.leftChild == null)
			{
				//Create new node with value
				newNode = new Node<T>(value);
				//Store new node as root's leftChild
				root.leftChild = newNode;
			}
			//If root's leftChild is not null
			else
			{
				addLeaf(root.leftChild, value);
			}
		}
	}
	
	/**
	 * Get all values in the tree.
	 */
	public ArrayList<T> getAllValues()
	{
		ArrayList<T> values = new ArrayList<T>();
		storeValues(topRoot, values);
		return values;
	}
	
	private void storeValues(Node<T> root, ArrayList<T> values)
	{
		if(root == null)
		{
			return;
		}
		
		storeValues(root.leftChild, values);
		values.add(root.value);
		storeValues(root.rightChild, values);
	}
}
