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
	public static int dp[][]=new int[100002][3];
	public static int happiness(int arr[][],int n,int m) {
		/*if(n==0) {
			if(m==0) 
				return Main.dp[0][0];
			else if(m==1)
				return Main.dp[0][1];
			else
				return Main.dp[0][2];
		}*/
		if(Main.dp[n][m]!=-1) {
			return Main.dp[n][m];
		}
		else if(m==0) {
			Main.dp[n][m]=arr[n][0]+Math.max(Main.happiness(arr, n-1, 1),Main.happiness(arr, n-1, 2));
			return Main.dp[n][m];
		}
		else if(m==1) {
			Main.dp[n][m]=arr[n][1]+Math.max(Main.happiness(arr, n-1, 0),Main.happiness(arr, n-1, 2));
			return Main.dp[n][m];
		}
		else {
			Main.dp[n][m]=arr[n][2]+Math.max(Main.happiness(arr, n-1, 0),Main.happiness(arr, n-1, 1));
			return Main.dp[n][m];
		}
	}
	public static void main(String []args) {
		for(int i=0;i<100002;i++) {
			for(int j=0;j<3;j++) {
				Main.dp[i][j]=-1;
			}
		}
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[][]=new int[N][3];
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
			arr[i][2]=sc.nextInt();
		}
		Main.dp[0][0]=arr[0][0];
		Main.dp[0][1]=arr[0][1];
		Main.dp[0][2]=arr[0][2];
	    int x=Main.happiness(arr,N-1,0);
	    int y=Main.happiness(arr,N-1,1);
	    int z=Main.happiness(arr,N-1,2);
		System.out.println(Math.max(x,Math.max(y, z)));
		sc.close();
	}
}
