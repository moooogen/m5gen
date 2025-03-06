package BOJ24444;
import java.util.*;
//메모리 초과

public class Main {
	static int[][] arr;
	static ArrayList<Integer> ans;
	static boolean[] visited;
	static int n,m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int s = sc.nextInt();
		arr = new int[n+1][n+1];
		ans = new ArrayList<Integer>();
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u][v] = 1;//연결되면 1, 안되어있으면 0
		}	
		visited =new boolean[n+1];
		bfs(s);
		//ans에 출현 순서대로 있음
		int index =1;
		int[] answer = new int[n];
		for(int i:ans) answer[i-1] = index++;
		for(int i:answer) System.out.println(i);
		
	}

	private static void bfs(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(s);//일단 시작점 넣고
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ans.add(node);//node가 몇번째인지만 기록
			
			
			//연결된 노드 찾기
			for(int i=1; i<=n; i++) {
				if(arr[node][i]==1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
		
		
		
	}

}
