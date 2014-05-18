package bst;
/**
 * This class extends BinarySearchTree, adding methods for analyzing the depth
 * of the tree.
 * @author Michael McMahon
 *
 */
public class DepthAnalyzingBST<T extends Comparable<T>>	
	extends BinarySearchTree<T>
{
	/**
	 * Gets the average depth of all leaves in the tree
	 * @return The average depth of leaves in the tree
	 */
	public float getAverageDepth()
	{
		//Get sum of all depths
		float depthSum = BST_Analyzer.sumDepths(topRoot, 1);
		//Get count of all leaves
		int leafCount = BST_Analyzer.countLeaves(topRoot);
		
		//Check that denominator is not zero
		if(leafCount > 0)
		{
			//depthSum is cast as float, so result will use float arithmetic
			return depthSum / leafCount;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * Gets the maximum depth of all leaves in the tree
	 * @return The maximum depth of leaves in the tree
	 */
	public int getMaxDepth()
	{
		return BST_Analyzer.maxDepth(topRoot, 1);
	}
}
