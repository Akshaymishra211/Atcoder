import java.util.*;
import java.io.*;
public class Main {
	public static int dp[]=new int[100005];
	public static boolean visited[]=new boolean[100005];
	public static void solve(ArrayList<ArrayList<Integer>> g,int node) {
		visited[node]=true;
		for(int child=0;child<g.get(node).size();child++) {
			if(!visited[g.get(node).get(child)])
				solve(g,g.get(node).get(child));
			dp[node]=Math.max(dp[node],1+dp[g.get(node).get(child)]);
			//System.out.println(node+" ---- "+g.get(node).get(child));
		}
					
		
	}
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int N,M;
		N=sc.nextInt();
		M=sc.nextInt();
		ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++) {
			graph.add(i,new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			graph.get(x).add(y);
		}
		for(int i=1;i<N+1;i++) {
			if(!visited[i])
				solve(graph,i);
		}
		int cnt=0;
		for(int i=0;i<100005;i++)
			cnt=Math.max(cnt,dp[i]);
		System.out.println(cnt);
	}

}
        
