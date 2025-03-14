// 인접 행렬

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_11724 {
	
	static int N, M, u,v;
	static int [][] graph;
	static boolean[] visited;

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
			
			
			for(int i = 0; i < M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph[u][v] = 1;
				graph[v][u] = 1;
			}
			
			int count = 0;
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i]) {
					dfs(i);
					count++;
				}
			}
			System.out.println(count);

	}
	static void dfs(int node) {
		if(visited[node] == true) {
			return;
		}
		visited[node] = true;
		
		for(int i= 1; i <= N; i++) {
			if(graph[node][i] == 1) {
				dfs(i);			
				}
		}
		
	}

}
