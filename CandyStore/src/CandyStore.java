
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CandyStore {
	
	static int[] knapsack(Scanner input, int n, int m)
	{
		int[] nKnapsack = new int[m + 1];


		for (int i=0; i<n; i++)
		{

			int calories = input.nextInt();
			int cCost = (int)(input.nextDouble()*100+.01);

			for (int j=cCost; j<nKnapsack.length; j++)
			{
				nKnapsack[j] = Math.max(nKnapsack[j], nKnapsack[j-cCost]+calories);
			}
		}
		
		return nKnapsack;
	}
	
	

	public static void main(String[] args) throws FileNotFoundException
	{
		
        File fInput = new File("Input.txt");
      
		Scanner scan = new Scanner(fInput);
		 
		int nCandies = scan.nextInt();
		
		int tCents = (int)(scan.nextDouble()*100+.01);
		
		while (nCandies != 0)
		{
			int[] nKnapsack = knapsack(scan, nCandies, tCents);
			
			System.out.println(nKnapsack[nKnapsack.length-1]);
			
			nCandies = scan.nextInt();
			tCents = (int)(scan.nextDouble()*100+.01);
			
		}
		
		scan.close();
	}
}