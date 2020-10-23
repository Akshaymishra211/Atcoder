import java.io.*;
import java.util.*;

public class Main {
	public static int dp[][][][]=new int[75][75][75][75];
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	public static int func(int i,int j,int cnt,int rem,int [][]arr,int n,int m,int k) {
		if(i==0)
			return 0;
		else if(dp[i][j][cnt][rem]!=-1)
			return dp[i][j][cnt][rem];
		else if(j==m+1 || cnt==0) {
			Main.dp[i][j][cnt][rem]=Main.func(i-1,1,m/2, rem, arr, n, m, k);
			return Main.dp[i][j][cnt][rem];
		}
		else {
			//lena hai
			int ans1=Main.func(i, j+1, cnt-1,(rem+arr[i][j])%k, arr, n, m, k);
			//checking condition that if we are considering arr[i][j] so will it gives us the expected output or not if it gives means totalsum%k will we 0; 
			if(ans1==0 && (rem+arr[i][j])%k!=0)
				ans1=0;
			else
				ans1=ans1+arr[i][j];
			//nhi lena hai
			int ans2=Main.func(i, j+1, cnt, rem, arr, n, m, k);
			Main.dp[i][j][cnt][rem]=Math.max(ans1,ans2);
			return Main.dp[i][j][cnt][rem];
		}
	}
	public static void solve(FastReader s) {
		for(int i=0;i<75;i++)
			for(int j=0;j<75;j++)
				for(int k=0;k<75;k++)
					for(int l=0;l<75;l++)
						Main.dp[i][j][k][l]=-1;
		//Main Code
		int N=s.nextInt();
		int M=s.nextInt();
		int K=s.nextInt();
		int matrix[][]=new int[N+1][M+1];
		for(int i=1;i<N+1;i++)
			for(int j=1;j<M+1;j++)
				matrix[i][j]=s.nextInt();
		System.out.println(Main.func(N,1,M/2,0,matrix,N,M,K));
	}

	public static void main(String[] args) throws Exception {
		FastReader sc = new FastReader();
		Main.solve(sc);
	}
}
