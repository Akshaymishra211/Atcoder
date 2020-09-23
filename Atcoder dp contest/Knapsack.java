/*					                                
		                                    *             * * * * * * * *
		                                    *             *
		                                    *             *
		                                    *             *
		                                    *             *
		                                    *             *
		                                    *             *
		                                    * * * * * * * * * * * * * * *
		                                                  *             *
		                                                  *             *
		                                                  *             *
		                                                  *             *
		                                                  *             *
		                                                  *             *
		                                    * * * * * * * *             *
		                                                         
*/
import java.util.*;
import java.io.*;
import java.lang.*;
class Main{
	public static long dp[][]=new long[102][100002];
	public static long knapsack(int wt[],int val[],int N,int W) {
		if(N<=0 || W<=0)
			return 0;
		else if(Main.dp[N-1][W]!=0)
			return Main.dp[N-1][W];
		else if(wt[N-1]<=W) {
			Main.dp[N-1][W]=Math.max(val[N-1]+Main.knapsack(wt, val, N-1, W-wt[N-1]),Main.knapsack(wt, val, N-1, W));
			return Main.dp[N-1][W];
		}
		else {
			Main.dp[N-1][W]=Main.knapsack(wt, val, N-1, W);
			return Main.dp[N-1][W];
		}
	}
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int W=sc.nextInt();
		int wt[]=new int[N];
		int val[]=new int[N];
		for(int i=0;i<N;i++){
			wt[i]=sc.nextInt();
			val[i]=sc.nextInt();
		}
		long ans=Main.knapsack(wt, val, N, W);
		System.out.println(ans);
		sc.close();
	}
}
