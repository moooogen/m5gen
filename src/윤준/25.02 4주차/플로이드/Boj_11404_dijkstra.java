import java.util.*;

public class Main {
    static final int INF = 100_000 * 100 + 1; // 최대 비용보다 큰 값 설정
    static int n, m;
    static int[][] graph;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = Math.min(graph[a][b], c); // 여러 노선이 있을 경우 최소 비용 선택
        }
        
        int[][] result = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = dijkstra(i);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((result[i][j] == INF ? 0 : result[i][j]) + " ");
            }
            System.out.println();
        }
    }
    
    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            if (visited[u]) continue;
            visited[u] = true;
            
            for (int v = 1; v <= n; v++) {
                if (graph[u][v] != INF && dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
