// Arup Guha
// 11/11/2012
// Solution to 2012 South East Regional Problem A (both D1, D2): Candy Store

import java.util.*;

public class CandyStore {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		int n = stdin.nextInt();
		int price = (int)(stdin.nextDouble()*100+.01);

		while (n != 0) {

			// Run the DP in cents.
			int[] dp = new int[price+1];

			// Loop through each item
			for (int i=0; i<n; i++) {

				// Get this info.
				int cal = stdin.nextInt();
				int thisPrice = (int)(stdin.nextDouble()*100+.01);

				// Run loop forward to allow to take as many of this candy as possible.
				for (int j=thisPrice; j<dp.length; j++)
					dp[j] = Math.max(dp[j], dp[j-thisPrice]+cal);
			}

			// Print the answer and go to the next case.
			System.out.println(dp[dp.length-1]);
			n = stdin.nextInt();
			price = (int)(stdin.nextDouble()*100+.01);
		}
	}
}