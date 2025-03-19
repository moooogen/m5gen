### 🚀 **최단 경로 알고리즘 비교 및 코드 분석**
---
## 🔹 **알고리즘 개요**
주어진 문제에서 **모든 정점 쌍 (A, B)의 최소 비용을 구하는 문제**를 해결하는 방법으로 다음 세 가지 방법을 비교 분석한다.

1. **플로이드-워셜 알고리즘 (Floyd-Warshall)**
2. **다익스트라 알고리즘 (Dijkstra - PriorityQueue)**
3. **개선된 다익스트라 알고리즘 (Dijkstra - TreeSet + HashMap)**

각 방법론의 **시간 복잡도, 메모리 사용량, 실행 속도**를 비교하여 가장 효율적인 방법을 선택한다.

---

## 🔹 **알고리즘 비교표**
| 알고리즘 | 시간 복잡도 | 공간 복잡도 | 특징 | 적합한 경우 |
|---|---|---|---|---|
| **플로이드-워셜** | `O(n^3)` | `O(n^2)` | 행렬 기반, 단순한 구현 | `n ≤ 100` |
| **다익스트라 (PriorityQueue)** | `O(n (m log n))` | `O(n + m)` | 인접 리스트 + 우선순위 큐 | `m`이 클 때 유용 |
| **개선된 다익스트라 (TreeSet + HashMap)** | `O(n (m log n))` | `O(n + m) (더 적음)` | TreeSet으로 빠른 삭제 + HashMap으로 메모리 절약 | **`m`이 매우 클 때 최적** |

- `m ≤ 100,000`일 경우 **플로이드-워셜은 부적절** (`O(100^3) = 10^6`이지만, `m`이 크면 속도가 낮아짐)
- `m`이 크다면 **다익스트라가 더 유리**
- `m`이 매우 크면 **TreeSet을 활용한 개선된 다익스트라가 가장 효과적**

---

## 📌 **코드 분석 및 최적화**
### 1️⃣ **플로이드-워셜 알고리즘**
- **시간 복잡도:** `O(n^3)`
- **공간 복잡도:** `O(n^2)` (인접 행렬 사용)
- **장점:** 구현이 간단, 모든 쌍의 최단 경로를 동시에 계산
- **단점:** `m`이 클 경우 매우 비효율적 (`m=100,000`일 때 비추천)

#### **코드**
```java
import java.util.*;

public class FloydWarshall {
    static final int INF = 100000000; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int[] row : dist) {
            for (int val : row) {
                System.out.print((val == INF ? 0 : val) + " ");
            }
            System.out.println();
        }
    }
}
```

---

### 2️⃣ **다익스트라 알고리즘 (PriorityQueue)**
- **시간 복잡도:** `O(n (m log n))`
- **공간 복잡도:** `O(n + m)`
- **장점:** `m`이 클 때 빠름, 효율적인 `PriorityQueue` 활용
- **단점:** `PriorityQueue`에서 중복된 노드를 여러 번 넣었다 빼야 함

#### **코드**
```java
import java.util.*;

public class DijkstraPriorityQueue {
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
}
```

---

### 3️⃣ **개선된 다익스트라 (TreeSet + HashMap)**
- **시간 복잡도:** `O(n (m log n))`
- **공간 복잡도:** `O(n + m) (더 적음)`
- **장점:** `PriorityQueue`보다 메모리 절약 (`TreeSet` 사용으로 불필요한 중복 제거)
- **단점:** `TreeSet` 정렬 연산이 약간의 오버헤드 발생

#### **코드**
```java
import java.util.*;

public class DijkstraTreeSet {
    static final int INF = 100000000;

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
            Node current = ts.pollFirst();
            int u = current.vertex;
            int cost = current.cost;

            if (!graph.containsKey(u)) continue;

            for (Map.Entry<Integer, Integer> entry : graph.get(u).entrySet()) {
                int v = entry.getKey();
                int weight = entry.getValue();

                if (dist[v] > cost + weight) {
                    ts.remove(new Node(v, dist[v]));
                    dist[v] = cost + weight;
                    ts.add(new Node(v, dist[v]));
                }
            }
        }
    }
}
```

---

## **✅ 최종 결론**
| 알고리즘 | 추천 상황 |
|---|---|
| **플로이드-워셜** | `n ≤ 100`일 때 적합 |
| **다익스트라 (PriorityQueue)** | `m`이 크고 일반적인 경우 적합 |
| **다익스트라 (TreeSet + HashMap)** | `m`이 매우 크고 메모리 최적화가 필요한 경우 최적 |

최적 :  `TreeSet + HashMap`을 사용한 다익스트라