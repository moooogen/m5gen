package BOJ11724;
import java.util.*;
//연결 요소의 개수 : 메모리(331016 kb), 시간(1672 ms)
public class Main {
	
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	static int n,m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new ArrayList<>();
		for(int i=0; i<=n; i++) arr.add(new ArrayList<>());
		visited = new boolean[n];
		int cnt =0;
		
		for(int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			 arr.get(u).add(v);
			 arr.get(v).add(u);
		}
		
		//따로 함수 분리 안하고 해보기
		Queue<Integer> queue = new LinkedList<Integer>();
		//처음값 넣기
		for(int i=1; i<=n; i++) {
			if(!visited[i-1]) {
				//방문하지 않은 점이면, 외딴 섬일때는 혼자 카운팅
				cnt++;
				queue.offer(i);
				visited[i-1] = true;
				while(!queue.isEmpty()) {
					int node = queue.poll();
					for(int link:arr.get(node)) {
						if(!visited[link-1]) {
							queue.add(link);
							visited[link-1] = true;
						}
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
