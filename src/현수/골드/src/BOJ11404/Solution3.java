package BOJ11404;
import java.util.*;
//다익스트라 : 메모리(246084 kb), 시간(1444 ms)
public class Solution3 {
    static final int INF = 100000000;

    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, cost;
        Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            if (this.cost == o.cost) return Integer.compare(this.vertex, o.vertex);
            return Integer.compare(this.cost, o.cost);
        }
    }

    static Map<Integer, Map<Integer, Integer>> graph;
    static int[][] result;

    public static void dijkstra(int start, int n) {
        TreeSet<Node> ts = new TreeSet<>();
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        ts.add(new Node(start, 0));

        while (!ts.isEmpty()) {
            Node current = ts.pollFirst();  // 최소 비용 노드 가져오기
            int u = current.vertex;
            int cost = current.cost;

            if (!graph.containsKey(u)) continue;

            for (Map.Entry<Integer, Integer> entry : graph.get(u).entrySet()) {
                int v = entry.getKey();
                int weight = entry.getValue();

                if (dist[v] > cost + weight) {
                    ts.remove(new Node(v, dist[v])); // 기존 값 제거 (없으면 무시됨)
                    dist[v] = cost + weight;
                    ts.add(new Node(v, dist[v])); // 새 값 추가
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

        graph = new HashMap<>();
        result = new int[n][n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            
            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, Math.min(graph.get(a).getOrDefault(b, INF), c));
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

