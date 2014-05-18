package bst;
/**
 * This class contains static methods which analyze a binary tree. Trees can be
 * analyzed for number of leaves, sum of leaf depths, and maximum leaf depth.
 * @author Michael McMahon
 *
 */
public class BST_Analyzer {
	
	/**
	 * Helper method to determine if a node is a leaf.
	 * @param node Node to check for leaf status.
	 * @return True if provided node's left and right children are both null, false otherwise.
	 */
	private static boolean isLeaf(Node node)
	{
		return node.leftChild == null && node.rightChild == null;
	}
	
	/**
	 * Counts the number of leaves in a tree.
	 * @param root Root of tree under which leaves will be counted
	 * @return The number of leaves under root
	 */
	public static int countLeaves(Node root)
	{
		//Root is null, does not add to leaf count
		if(root == null)
		{
			return 0;
		}
		
		//Root is a leaf, add one to leaf count
		if(isLeaf(root))
		{
			return 1;
		}
		
		/*Root is not null or leaf, return number of leaves in left and right 
		 * subtrees
		 */
		return countLeaves(root.leftChild) + countLeaves(root.rightChild);
	}
	
	/**
	 * Sums the depths of all leaves in a tree.
	 * @param root Root underwhich leaf depths will be summed
	 * @param depth The starting depth of the root
	 * @return Sum of the depths of all leaves under root
	 */
	public static int sumDepths(Node root, int depth)
	{
		//Root is null, don't add to sum
		if(root == null)
		{
			return 0;
		}
		
		//Root is leaf, add depth to sum
		if(isLeaf(root))
		{
			return depth;
		}
		
		//Root is not null or leaf
		return sumDepths(root.leftChild, depth + 1) + 
				sumDepths(root.rightChild, depth + 1);
	}
	
	/**
	 * Gets the maximum depth of all leaves in a tree.
	 * @param root The root under which to find the maximum leaf depth.
	 * @param depth The starting depth of the root.
	 * @return The maximum depth of a leaf under the root
	 */
	public static int maxDepth(Node root, int depth)
	{
		//Root is null, don't compare depth
		if(root == null)
		{
			return 0;
		}
		
		//Root is leaf, compare it's depth
		if(isLeaf(root))
		{
			return depth;
		}
		
		//Root is not null or leaf, compare depth of left and right subtrees
		return Math.max(maxDepth(root.leftChild, depth + 1), 
				maxDepth(root.rightChild, depth + 1));
	}
}
