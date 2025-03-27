import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

	
public class Boj_1260 {
	
	static int N, M, R;
	static ArrayList<Integer>[] graph;
	static boolean[] visited; 
	static boolean[] visited2;
	static ArrayList<Integer> dfsorder;
	static ArrayList<Integer> bfsorder;
	static int order = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		visited = new boolean[N+1];
		visited2 = new boolean[N+1];
		graph = new ArrayList[N+1];
		dfsorder = new ArrayList<>();
		bfsorder = new ArrayList<>();
		
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph[u].add(v);
		    graph[v].add(u);
		}

		
		
		
		for(int i = 1; i <= N; i++) {
		 Collections.sort(graph[i]);
		
		}
		
		
		dfs(R);
		bfs(R);
		
		for(int i = 0; i < dfsorder.size(); i++) {
			System.out.print(dfsorder.get(i)+" ");
		}
		System.out.println();
		for(int i = 0; i < bfsorder.size(); i++) {
			System.out.print(bfsorder.get(i)+" ");
		}
	}
	
	static void dfs(int R) {
		visited[R] = true;
		dfsorder.add(R);
		
		for(int i = 0; i < graph[R].size(); i++) {
				int v = graph[R].get(i);
				if(!visited[v]) {
				dfs(v);
				}
		}
		
		
	}
	
	static void bfs(int R) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(R);
		visited2[R] = true;
		bfsorder.add(R);
		
		while(!qu.isEmpty()) {
			int next = qu.poll();
			
			for(int i = 0; i < graph[next].size(); i++) {
				int v = graph[next].get(i);
				
				if(!visited2[v]) {
				visited2[v] = true;
				qu.add(v);
				bfsorder.add(v);
				}
			}
		}
			
	}

}
