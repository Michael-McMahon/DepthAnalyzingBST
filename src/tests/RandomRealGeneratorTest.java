package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import tests.RandomChecker.Result;

import bst.RandomRealGenerator;

public class RandomRealGeneratorTest {
	private static final int MAX_SEQ_SIZE = 10;
	
	/**
	 * Create random set of real numbers.
	 * @param size The number of random numbers in the set
	 * @return Array of random numbers
	 */
	private float[] getRandomSet(int size)
	{
		float[] set = new float[size];
		RandomRealGenerator randomGenerator = new RandomRealGenerator();
		
		int i;
		for(i = 0; i < size; i++)
		{
			set[i] = randomGenerator.nextReal();
		}
		
		return set;
	}
	
	private float[] getNotSoRandomSet(int size)
	{
		float[] set = new float[size];
		Random r = new Random();
		int i;
		
		for(i = 0; i < size; i++)
		{
			set[i] = r.nextInt(10);
		}
		
		return set;
	}
	
	private void reportResults(ArrayList<Result> results, int size)
	{
		if(results == null || results.size() == 0)
		{
			System.out.println("\tNo repeating sequences of length " + size + " found");
			return;
		}
		else
		{
			System.out.println("\tFound " + results.size() + 
					" repeating sequences of length " + size);
		}
		
		for(Result res : results)
		{
			System.out.println("\t\tSequence " + 
				Arrays.toString(res.getSequence()) + " appears " + 
					res.getFrequency() + " times");
		}
	}
	
	@Test
	public void testRandomChecker1() {
		RandomChecker checker = new RandomChecker();
		float[] set = {1, 1};
		
		ArrayList<Result> results = checker.checkSequences(1, set);
		
		assertEquals("RandomChecker returns wrong number of results", 1, results.size());
		
		Result res = results.get(0);
		float[] expectedSeq = {1f};
		assertArrayEquals("RandomChecker returns wrong sequence", expectedSeq, res.getSequence(), 0);
		assertEquals("RandomChecker returns wrong frequency", 2, res.getFrequency());
	}
	
	
	@Test
	public void testRandomChecker2() {
		RandomChecker checker = new RandomChecker();
		float[] set = {1, 2, 1, 2, 1, 1, 1, 2, 9, 10};
		float[] expectedSeq1 = {1f, 2f};
		float[] expectedSeq2 = {2f, 1f};
		float[] expectedSeq3 = {1f, 1f};
		
		Result expected1 = checker.new Result(expectedSeq1, 3);
		Result expected2 = checker.new Result(expectedSeq2, 2);
		Result expected3 = checker.new Result(expectedSeq3, 2);
		Result[] expResults = {expected1, expected2, expected3};
		Result actual;
		int actualIndex;
		
		ArrayList<Result> results = checker.checkSequences(2, set);
		
		assertEquals("RandomChecker returns wrong number of results", 3, results.size());
		for(Result exp : expResults)
		{
			actualIndex = results.indexOf(exp);
			assertTrue("Expected sequence " + Arrays.toString(exp.getSequence()) +
					" missing from results", actualIndex >= 0);
			
			actual = results.get(actualIndex);
			assertEquals("Expected frequency differs from results", 
					exp.getFrequency(),	actual.getFrequency());
		}
	}
	
	@Test
	public void testRandomRealGenerator10k()
	{
		RandomChecker checker = new RandomChecker();
		int size = 10000;
		float[] set;
		int i;
		ArrayList<Result> results = null;
		
		System.out.println("Testing randomness of " + size + " values...");
		
		set = getRandomSet(size);
		
		for(i = 1; i <= MAX_SEQ_SIZE; i++)
		{
			results = checker.checkSequences(i, set);
			reportResults(results, i);
		}
	}
	
	@Test
	public void testRandomRealGenerator50k()
	{
		RandomChecker checker = new RandomChecker();
		int size = 50000;
		float[] set;
		int i;
		ArrayList<Result> results = null;
		
		System.out.println("Testing randomness of " + size + " values...");
		
		set = getRandomSet(size);
		
		for(i = 1; i <= MAX_SEQ_SIZE; i++)
		{
			results = checker.checkSequences(i, set);
			reportResults(results, i);
		}
	}
	
	/*
	@Test
	public void testRandomRealGeneratorNotSoRandom()
	{
		RandomChecker checker = new RandomChecker();
		int size = 100;
		float[] set;
		int i;
		ArrayList<Result> results = null;
		
		System.out.println("Testing randomness of " + size + " values between 0 and 10...");
		
		set = getNotSoRandomSet(size);
		
		for(i = 1; i <= MAX_SEQ_SIZE; i++)
		{
			results = checker.checkSequences(i, set);
			reportResults(results, i);
		}	
	}
	*/
}
