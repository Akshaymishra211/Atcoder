import java.io.*;
import java.util.*;

public class Main {
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
		if(i==-1)
			return 0;
		else if(j==-1 || cnt==0)
			return Main.func(i-1,m-1,m/2, rem, arr, n, m, k);
		else {
			//lena hai
			int ans1=Main.func(i, j-1, cnt-1,(rem+arr[i][j])%k, arr, n, m, k);
			//checking condition that if we are considering arr[i][j] so will it gives us the expected output or not if it gives means totalsum%k will we 0; 
			if(ans1==0 && (rem+arr[i][j])%k!=0)
				ans1=0;
			else
				ans1=ans1+arr[i][j];
			//nhi lena hai
			int ans2=Main.func(i, j-1, cnt, rem, arr, ans1, m, k);
			ans1=Math.max(ans1,ans2);
			return ans1;
		}
	}
	public static void solve(FastReader s) {
		//Main Code
		int N=s.nextInt();
		int M=s.nextInt();
		int K=s.nextInt();
		int matrix[][]=new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				matrix[i][j]=s.nextInt();
		System.out.println(Main.func(N-1,M-1,M/2,0,matrix,N,M,K));
	}

	public static void main(String[] args) throws Exception {
    //It will give TLE as it complexity is exponential but we can make it polynomial using memoization i.e recursive dp bottom up approach
		FastReader sc = new FastReader();
		Main.solve(sc);
	}
}
