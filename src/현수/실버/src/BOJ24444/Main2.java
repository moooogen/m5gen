package BOJ24444;
import java.util.*;

public class Main2 {
	
	static ArrayList<ArrayList<Integer>> arr;
	static int[] ans;
	static boolean[] visited;
	static int n,m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int s = sc.nextInt();
		
		arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) arr.add(new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr.get(u).add(v);
            arr.get(v).add(u);
		}	
		visited =new boolean[n+1];
		ans = new int[n];
		for (int i = 1; i <= n; i++) Collections.sort(arr.get(i));
		bfs(s);
		for(int i:ans) System.out.println(i);
		
	}

	private static void bfs(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int idx=1;
		queue.offer(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ans[node-1] = idx++; //poll된 node의 순서 idx를 ans에 기록
			for(int link:arr.get(node)) {
				if(!visited[link]) {
					queue.offer(link);
					visited[link]=true;
				}
			}
		}
	}
}
