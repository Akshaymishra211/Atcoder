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
	public int dp[][];
	public Main(int m,int n) {
		this.dp=new int[m+1][n+1];
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				dp[i][j]=-1;
			}
		}
	}
	public StringBuilder lcs(String text1,String text2,int m,int n) {
		int temp=this.solve(text1, text2, m, n);
		String common="";
		int i=m,j=n;
		while(i>0 && j>0) {
			if(text1.charAt(i-1)==text2.charAt(j-1)) {
				common=common+text1.charAt(i-1);
				i--;
				j--;
			}
			else {
				if(this.dp[i-1][j]<=this.dp[i][j-1]){
					j--;
				}
				else {
					i--;
				}
			}
		}
		StringBuilder input1=new StringBuilder();
		input1.append(common);
		input1=input1.reverse();
		return input1;
	}
	public int solve(String s1,String s2,int x,int y) {
		if(x==0 || y==0)
			return this.dp[x][y];
		else if(dp[x][y]!=-1)
			return this.dp[x][y];
		else {
			if(s1.charAt(x-1)==s2.charAt(y-1)){
				this.dp[x][y]=1+this.solve(s1,s2,x-1,y-1);
				return this.dp[x][y];
			}
			else {
				this.dp[x][y]=Math.max(this.solve(s1,s2,x,y-1),this.solve(s1,s2,x-1,y));
				return this.dp[x][y];
			}
		}
	}
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String t=sc.nextLine();
		int m=s.length();
		int n=t.length();
		Main obj=new Main(m,n);
		StringBuilder ans=obj.lcs(s,t,m,n);
		System.out.println(ans);
	}
}
