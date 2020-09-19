import java.util.*;
import java.io.*;
import java.lang.*;
class Main{
	public static int dp[]=new int[100002];
	public static int frog(int arr[],int N,int K) {
		if(N==0)
			return Main.dp[0];
		if(Main.dp[N]!=-1)
			return Main.dp[N];
		int cnt=1000000000;
		for(int i=N-1;i>Math.max(N-K-1,-1);i--) {
			cnt=Math.min(cnt,Main.frog(arr,i,K)+Math.abs(arr[N]-arr[i]));
			//System.out.println(cnt);
		}
		Main.dp[N]=cnt;
		return Main.dp[N];
	}
	public static void main(String []args) {
		for(int i=1;i<100002;i++) {
			Main.dp[i]=-1;
		}
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int h[]=new int[N];
		for(int i=0;i<N;i++) {
			h[i]=sc.nextInt();
		}
		int x=Main.frog(h, N-1, K);
		//System.out.println(x);
		System.out.println(Main.dp[N-1]);
	}
}
