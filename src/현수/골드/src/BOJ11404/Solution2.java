package BOJ11404;
import java.util.*;
//다익스트라 : 메모리(246084 kb), 시간(1444 ms)
public class Solution2 {
    static final int INF = 100000000;

    static class Edge implements Comparable<Edge> {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<List<Edge>> graph;
    static int[][] result;
    
    public static void dijkstra(int start, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;
            int cost = current.cost;

            if (cost > dist[u]) continue;

            for (Edge next : graph.get(u)) {
                if (dist[next.to] > cost + next.cost) {
                    dist[next.to] = cost + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result[start][i] = (dist[i] == INF ? 0 : dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        for (int i = 0; i < n; i++) {
            dijkstra(i, n);
        }

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

