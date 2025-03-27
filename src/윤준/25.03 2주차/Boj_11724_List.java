// 인접 리스트


import java.util.*;

public class Boj_11724_List {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        
        graph = new ArrayList[N + 1]; // 1부터 N까지 사용
        visited = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        
        sc.close();

        int count = 0; // 연결 요소 개수

        // 모든 정점에 대해 DFS 실행
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문하지 않은 정점이면 새로운 연결 요소
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int node) {
        visited[node] = true;
        
        for(int i = 0; i < graph[node].size(); i++) {
        	int next = graph[node].get(i);
        	if(visited[next] == false) {
        		dfs(next);
        	}
        }
    }
}
