	
import java.util.*;
	
public class BOJ_24444  {
			 static List<Integer>[] adj; // 인접 리스트
			    static int[] visitorder; // 방문 순서 저장 배열
			    static boolean[] visited; // 방문 여부 체크
			    static int N, M, R; // 정점 개수, 간선 개수, 시작 정점

			    public static void main(String[] args) {
			        Scanner sc = new Scanner(System.in);

			        // 입력 받기
			        N = sc.nextInt();
			        M = sc.nextInt();
			        R = sc.nextInt();

			        adj = new ArrayList[N + 1]; // 인접 리스트 초기화
			        visitorder = new int[N + 1]; // 방문 순서 배열
			        visited = new boolean[N + 1]; // 방문 여부 배열

			        for (int i = 1; i <= N; i++) {
			            adj[i] = new ArrayList<>();
			        }

			        // 간선 정보 저장 (양방향)
			        for (int i = 0; i < M; i++) {
			            int u = sc.nextInt();
			            int v = sc.nextInt();
			            adj[u].add(v);
			            adj[v].add(u);
			        }

			        // 인접 정점 오름차순 정렬
			        for (int i = 1; i <= N; i++) {
			            Collections.sort(adj[i]);
			        }

			        // BFS 실행
			        bfs();

			        // 결과 출력
			        for (int i = 1; i <= N; i++) {
			            System.out.println(visitorder[i]);
			        }

			        sc.close();
			    }

			    public static void bfs() {
			        Queue<Integer> queue = new LinkedList<>();
			        queue.add(R); // 시작 정점 add 및 방문체크
			        visited[R] = true;
			        int order = 1; // 방문 순서 카운트
			        visitorder[R] = order;

			        while (!queue.isEmpty()) {
			            int curr = queue.poll(); // 정점 하나를 꺼낼 꺼야
			            
			            // 나와 인접 하면서 방문하지 않은 친구들을 방문 할거야.
			            for (int v : adj[curr]) { // 인접 정점 탐색
//			            	for(int i = 0; i < adj[curr].size(); i++) {
//			            		int v = adj[curr].get(i); 
//			            	} 와 동일 
			                if (!visited[v]) {
			                	queue.add(v);
			                    visited[v] = true;
			                    visitorder[v] = ++order;
			                }
			            }
			        }
			    }
			}
	
