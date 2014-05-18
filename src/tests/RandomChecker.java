package tests;

import java.util.ArrayList;
import java.util.Arrays;

import bst.RandomRealGenerator;

public class RandomChecker {
	
	/**
	 * Data structure containing a sequence of numbers and the number of times
	 * that sequence appeared in a set.
	 * @author Michael McMahon
	 *
	 */
	public class Result
	{
		private float[] sequence;
		private int frequency;		
		
		public Result(float[] sequence, int frequency)
		{
			this.sequence = Arrays.copyOf(sequence, sequence.length);
			this.frequency = frequency;
		}
		
		public float[] getSequence()
		{
			return sequence;
		}
		
		public int getFrequency()
		{
			return frequency;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if(obj == null)
			{
				return false;
			}
			
			if(obj == this)
			{
				return true;
			}
			
			if(!(obj instanceof Result))
			{
				return false;
			}
			
			Result result = (Result) obj;
			
			if(!Arrays.equals(this.sequence, result.sequence))
			{
				return false;
			}
			
			return true;
		}
	}
	
	private void addResult(float[] sequence, int frequency, 
			ArrayList<Result> results)
	{
		Result newResult = new Result(sequence, frequency);
		
		if(!results.contains(newResult))
		{
			results.add(newResult);
		}
	}
	
	/**
	 * Finds repeating sequences of numbers within a set.
	 * @param seqSize The length of sequences to search
	 * @param set The set to search
	 * @return List of Result objects containing sequences and their frequencies
	 */
	public ArrayList<Result> checkSequences(int seqSize, float[] set)
	{
		float[] sequence = new float[seqSize];
		int setLen = set.length;
		ArrayList<Result> results = new ArrayList<Result>();
		int copyIndex, frequency, seqStart;
		
		for(seqStart = 0; seqStart < (setLen - seqSize); seqStart++)
		{
			//Copy next seqSize values into sequence
			for(copyIndex = 0; copyIndex < seqSize; copyIndex++)
			{
				sequence[copyIndex] = set[seqStart + copyIndex];
			}
			
			frequency = 1 + getFrequency(sequence, set, seqStart+1);
			//Add new result if sequence appears more than once
			if(frequency > 1)
			{
				addResult(sequence, frequency, results);
			}
		}
		
		return results;
	}
	
	/**
	 * Count the number of times a sequence appears in a set.
	 * @param sequence Sequence to find in set
	 * @param set Set to search
	 * @param start Index in set where search will start
	 * @return Count of sequence's recurrences in set.
	 */
	private int getFrequency(float[] sequence, float[] set, int start)
	{
		int frequency = 0;
		int checkIndex, seqIndex;
		boolean repeat;
		final int seqLength = sequence.length;
		final int setLength = set.length;
		
		for(checkIndex = start; checkIndex <= setLength - seqLength; checkIndex++)
		{
			//System.out.println("Checkindex " + checkIndex + " upto " + (setLength - seqLength));
			repeat = true;
			for(seqIndex = 0; repeat && seqIndex < seqLength; seqIndex++)
			{
				//System.out.println("Sequence " + Arrays.toString(sequence) + " index " + seqIndex + " comp " + set[seqIndex + checkIndex]);
				repeat = sequence[seqIndex] == set[seqIndex + checkIndex];
			}
			
			if(repeat)
			{
				frequency++;
			}
		}
		
		return frequency;
	}
}
