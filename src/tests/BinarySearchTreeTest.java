package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import bst.BinarySearchTree;
import bst.Node;

public class BinarySearchTreeTest {
	
	/**
	 * Helper class validates ordering of node values.
	 */
	public class TestableTree extends BinarySearchTree<Float>
	{
		public boolean testNodeOrder()
		{
			return testOrder(topRoot);
		}
		
		private boolean testOrder(Node<Float> root)
		{
			boolean valid = true;
			
			if(root == null)
			{
				return valid;
			}
			
			if(root.leftChild != null)
			{
				valid &= root.value > root.leftChild.value;
				valid &= testOrder(root.leftChild);
			}
			
			if(root.rightChild != null)
			{
				valid &= root.value <= root.rightChild.value;
				valid &= testOrder(root.rightChild);
			}
			
			return valid;
		}
	}
	
	@Test
	public void testRightChildren() {
		BinarySearchTree<Float> bst = new BinarySearchTree<Float>();
		Float[] expected = {1f, 2f, 3f, 4f, 5f};

		for(Float value : expected)
		{
			bst.insert(value);
		}
		
		Float[] actual = bst.getAllValues().toArray(new Float[5]);
		
		assertArrayEquals("Tree failed to return inserted values", expected, 
				actual);
	}

	@Test
	public void testLeftChildren() {
		BinarySearchTree<Float> bst = new BinarySearchTree<Float>();
		Float[] expected = {1f, 2f, 3f, 4f, 5f};
		int i = expected.length;
		
		while(i-- > 0)
		{
			bst.insert(expected[i]);
		}
		
		Float[] actual = bst.getAllValues().toArray(new Float[5]);
		
		assertArrayEquals("Tree failed to return inserted values", expected, 
				actual);
	}
	
	@Test
	public void testBalancedChildren() {
		BinarySearchTree<Float> bst = new BinarySearchTree<Float>();
		Float[] expected = {5f, 2f, 1f, 3f, 7f, 6f, 8f};
		
		for(Float value : expected)
		{
			bst.insert(value);
		}
		
		ArrayList<Float> actual = bst.getAllValues();
		

		assertEquals("Number of nodes in tree does not match number of " +
				"nodes inserted", expected.length, actual.size());
		for(Float value : expected)
		{
			assertTrue("Inserted value missing from tree", 
					actual.contains(value));
		}
	}
	
	@Test
	public void testNodeOrdering() {
		TestableTree bst = new TestableTree();
		Float[] values = {5f, 2f, 1f, 3f, 7f, 6f, 8f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		assertTrue("Nodes in tree are ordered incorrectly", bst.testNodeOrder());
	}
}
