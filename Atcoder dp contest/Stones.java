import java.util.*;
import java.io.*;
public class Main {
	public static int dp[]=new int[100005];
	public static int solve(int arr[],int K) {
		if(K==0)
			return dp[0];
		else if(Main.dp[K]!=-1)
			return dp[K];
		else {
			for(int i=0;i<arr.length;i++) {
				if(K>=arr[i]) {
					int x=Main.solve(arr, K-arr[i]);
					if(x==0) {
						dp[K]=1;
						return dp[K];
					}
				}
			}
			dp[K]=0;
			return dp[K];
		}
	}
	public static void main(String[] args) throws Exception {
		for(int i=1;i<100005;i++)
			Main.dp[i]=-1;
		Scanner sc=new Scanner(System.in);
		int N,K;
		N=sc.nextInt();
		K=sc.nextInt();
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		Main.solve(arr,K);
		if(Main.dp[K]==1)
			System.out.println("First");
		else
			System.out.println("Second");
	}

}
        
