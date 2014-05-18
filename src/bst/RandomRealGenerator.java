package bst;
import java.util.Random;

/**
 * Generates random real numbers in the range of Integer.MIN_VALUE 
 * (-2,147,483,648) and Integer.MAX_VALUE (2,147,483,647). 
 * @author Michael McMahon
 * 
 */
public class RandomRealGenerator {
	//Instance of the java.util.Random class which generates random values.
	private Random randomGenerator;
	
	/**
	 * Creates a new random real number generator with a unique seed.
	 */
	public RandomRealGenerator()
	{
		randomGenerator = new Random();
	}
	
	/**
	 * Generates the next random real number.
	 * @return Random real number.
	 */
	public float nextReal()
	{
		//base is a random integer
		int base = randomGenerator.nextInt();
		//scale is a random fraction, between 0.0 and 1.0
		float scale = randomGenerator.nextFloat();
		//return product of base and scale
		return base * scale;
	}
}
