package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import bst.BinarySearchTree;
import bst.DepthAnalyzingBST;

public class DepthAnalyzingBSTTest {

	@Test
	public void testGetAverageDepthEmpty() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 0f;
		float actual = bst.getAverageDepth();
		
		assertEquals("Average depth of empty tree should be zero", expected, 
				actual, 0);
	}

	@Test
	public void testGetAverageDepthSingle() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 1f;
		float actual;
		
		bst.insert(1f);
		actual = bst.getAverageDepth();
		
		assertEquals("Incorrect average depth for tree with one node", expected, 
				actual, 0);
	}
	
	@Test
	public void testGetAverageDepthRightChildren() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 5f;
		float actual;
		Float[] values = {1f, 2f, 3f, 4f, 5f};
		
		int i = values.length;
		
		while(i-- > 0)
		{
			bst.insert(values[i]);
		}
		
		actual = bst.getAverageDepth();
		
		assertEquals("Incorrect average depth for tree with one leaf at depth 5"
				, expected,	actual, 0);
	}
	
	@Test
	public void testGetAverageDepthLeftChildren() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 5f;
		float actual;
		
		Float[] values = {1f, 2f, 3f, 4f, 5f};

		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getAverageDepth();
		
		assertEquals("Incorrect average depth for tree with one leaf at depth 5"
				, expected,	actual, 0);
	}
	
	@Test
	public void testGetAverageDepthBalanced() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 3;
		float actual;
		Float[] values = {5f, 2f, 1f, 3f, 7f, 6f, 8f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getAverageDepth();
		

		assertEquals("Incorrect average depth for tree with four leaves at " +
				"depth 3", expected, actual, 0);
	}

	@Test
	public void testGetAverageDepthUnbalanced1() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 3;
		float actual;
		Float[] values = {5f, 2f, 1f, 4f, 3f, 6f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getAverageDepth();
		
		assertEquals("Incorrect average depth for tree with 3 leaves at " +
				"depths 2, 3, and 4", expected, actual, 0);
	}
	
	@Test
	public void testGetAverageDepthUnbalanced2() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 3.75f;
		float actual;
		Float[] values = {5f, 2f, 1f, 4f, 3f, 6f, 10f, 9f, 11f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getAverageDepth();
		
		assertEquals("Incorrect average depth for tree with 4 leaves at " +
				"depths 3, 4, 4, and 4", expected, actual, 0);
	}
	
	@Test
	public void testGetMaxDepthEmpty() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 0f;
		float actual = bst.getMaxDepth();
		
		assertEquals("Max depth of empty tree should be zero", expected, 
				actual, 0);
	}

	@Test
	public void testGetMaxDepthSingle() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 1f;
		float actual;
		
		bst.insert(1f);
		actual = bst.getMaxDepth();
		
		assertEquals("Incorrect Max depth for tree with one node", expected, 
				actual, 0);
	}
	
	@Test
	public void testGetMaxDepthRightChildren() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 5f;
		float actual;
		Float[] values = {1f, 2f, 3f, 4f, 5f};
		
		int i = values.length;
		
		while(i-- > 0)
		{
			bst.insert(values[i]);
		}
		
		actual = bst.getMaxDepth();
		
		assertEquals("Incorrect Max depth for tree with one leaf at depth 5"
				, expected,	actual, 0);
	}
	
	@Test
	public void testGetMaxDepthLeftChildren() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 5f;
		float actual;
		
		Float[] values = {1f, 2f, 3f, 4f, 5f};

		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getMaxDepth();
		
		assertEquals("Incorrect Max depth for tree with one leaf at depth 5"
				, expected,	actual, 0);
	}
	
	@Test
	public void testGetMaxDepthBalanced() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 3;
		float actual;
		Float[] values = {5f, 2f, 1f, 3f, 7f, 6f, 8f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getMaxDepth();
		

		assertEquals("Incorrect Max depth for tree with four leaves at " +
				"depth 3", expected, actual, 0);
	}

	@Test
	public void testGetMaxDepthUnbalanced1() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 4;
		float actual;
		Float[] values = {5f, 2f, 1f, 4f, 3f, 6f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getMaxDepth();
		
		assertEquals("Incorrect Max depth for tree with 3 leaves at " +
				"depths 2, 3, and 4", expected, actual, 0);
	}
	
	@Test
	public void testGetMaxDepthUnbalanced2() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 4f;
		float actual;
		Float[] values = {5f, 2f, 1f, 4f, 3f, 6f, 10f, 9f, 11f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getMaxDepth();
		
		assertEquals("Incorrect Max depth for tree with 4 leaves at " +
				"depths 3, 4, 4, and 4", expected, actual, 0);
	}
	
	@Test
	public void testGetMaxDepthUnbalanced3() {
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		float expected = 6f;
		float actual;
		Float[] values = {5f, 2f, 1f, 4f, 3f, 6f, 10f, 9f, 11f, 9f, 8f, 7f};
		
		for(Float value : values)
		{
			bst.insert(value);
		}
		
		actual = bst.getMaxDepth();
		
		assertEquals("Incorrect Max depth for tree with 4 leaves at " +
				"depths 3, 4, 4, and 6", expected, actual, 0);
	}
}
