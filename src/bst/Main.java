package bst;

/**
 * The main class creates a BST and reports the depth analysis results.
 * @author Michael McMahon
 *
 */
public class Main {
	//The default number of nodes to be stored in the tree
	private static final int DEFAULT_SIZE = 1023;
	
	/**
	 * Creates a new binary search tree containing the specified amount of 
	 * randomly generated real numbers
	 * @param size The size of the tree 
	 * @return A binary search tree containing the specified number of random real numbers
	 */
	private DepthAnalyzingBST<Float> createTree(int size)
	{
		DepthAnalyzingBST<Float> bst = new DepthAnalyzingBST<Float>();
		RandomRealGenerator numberGenerator = new RandomRealGenerator();
		int i = 0;
		
		while(i++ < size)
		{
			bst.insert(numberGenerator.nextReal());
		}
		
		return bst;
	}
	
	/**
	 * Gets the average leaf depth from the specified tree and prints the 
	 * result to the standard output stream.
	 * @param bst Binary search tree whose average depth will be reported.
	 */
	private void reportAverageDepth(DepthAnalyzingBST<Float> bst)
	{
		float avgDepth = bst.getAverageDepth();
		
		System.out.println("\tAverage depth is: " + avgDepth);
	}
	
	/**
	 * Gets the maximum leaf depth from the specified tree and prints the 
	 * result to the standard output stream.
	 * @param bst Binary search tree whose maximum depth will be reported.
	 */
	private void reportMaxDepth(DepthAnalyzingBST<Float> bst)
	{
		int maxDepth = bst.getMaxDepth();
		
		System.out.println("\tMaximum depth is: " + maxDepth);
	}
	
	/**
	 * Creates a binary search tree of the specified size and reports the tree’s 
	 * average and maximum depth on the standard output stream
	 * @param size Number of nodes contained in tree.
	 */
	public void run(int size)
	{
		DepthAnalyzingBST<Float> bst;
		System.out.println("\nCreating a binary sort tree contianing " + size + 
				" random real numbers.");
		 bst = createTree(size);
		 reportAverageDepth(bst);
		 reportMaxDepth(bst);
	}
	
	/**
	 * Starts the process. Accepts a single integer argument which specifies
	 * how many nodes to create in the tree.
	 * @param args
	 */
	public static void main(String[] args)
	{
		int size = DEFAULT_SIZE;
		
		//User can pass a single argument to specify a non-default size
		if(args.length > 1)
		{
			System.out.println("Provide up to one argument for specifying " +
					"a non-default size");
			return;
		}
		
		if(args.length == 1)
		{
			try
			{
				size = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Argument must be an integer value");
				return;
			}
		}
		
		new Main().run(size);
	}
}
