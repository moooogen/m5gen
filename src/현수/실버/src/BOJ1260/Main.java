package BOJ1260;
import java.util.*;
// DFS와 BFS : 메모리(39364 kb), 시간(504 ms)
public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int v = sc.nextInt(); 

        arr = new ArrayList[n + 1]; 
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);
    }

    static void dfs(int node) {
        visited[node] = true;//시작점 방문 처리
        System.out.print(node + " ");

        for (int next : arr[node]) {//연결된 정점 리스트 돌기
            if (!visited[next]) {
                dfs(next);//방문안했으면 재귀
                //fasle 처리는 다시 방문 안할거니까 X
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : arr[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        System.out.println();
    }
}
