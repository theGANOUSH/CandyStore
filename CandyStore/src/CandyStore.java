
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CandyStore {

	public static void main(String[] args) throws FileNotFoundException {
		
		  
        //creating File instance to reference text file in Java
        File fInput = new File("Input.txt");
      
		Scanner scan = new Scanner(fInput);

		int n = scan.nextInt();
		
		int price = (int)(scan.nextDouble()*100+.01);

		while (n != 0)
		{

			// Run the DP in cents.
			int[] dp = new int[price+1];

			// Loop through each item
			for (int i=0; i<n; i++)
			{

				// Get this info.
				int cal = scan.nextInt();
				int thisPrice = (int)(scan.nextDouble()*100+.01);

				// Run loop forward to allow to take as many of this candy as possible.
				for (int j=thisPrice; j<dp.length; j++)
					dp[j] = Math.max(dp[j], dp[j-thisPrice]+cal);
			}

			// Print the answer and go to the next case.
			System.out.println(dp[dp.length-1]);
			n = scan.nextInt();
			price = (int)(scan.nextDouble()*100+.01);
		}
		
		
		
		scan.close();
	}
}