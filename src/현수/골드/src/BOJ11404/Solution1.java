package BOJ11404;
import java.util.*;
//플로이드 워셜 : 메모리(241176 kb), 시간(1200 ms)
public class Solution1 {
    static final int INF = 1000000000; // 무한대 값 설정
    static int n, m;
    static int[][] fee;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 도시 개수
        m = sc.nextInt(); // 노선 개수
        fee = new int[n][n];

        // 비용 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(fee[i], INF); // INF(매우 큰 값)으로 초기화
            fee[i][i] = 0; // 자기 자신으로 가는 경로는 0
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int input = sc.nextInt();
            fee[start][end] = Math.min(fee[start][end], input); // 최소값만 유지
        }

        // 플로이드-워셜 알고리즘 수행
        for (int k = 0; k < n; k++) { // 경유지
            for (int s = 0; s < n; s++) { // 출발 도시
                for (int e = 0; e < n; e++) { // 도착 도시
                    if (fee[s][k] != INF && fee[k][e] != INF) { // 경유 가능할 때만 갱신
                        fee[s][e] = Math.min(fee[s][e], fee[s][k] + fee[k][e]);
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fee[i][j] == INF) System.out.print("0 ");
                else System.out.print(fee[i][j] + " ");
            }
            System.out.println();
        }
    }
}
