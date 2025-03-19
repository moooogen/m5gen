import java.util.Scanner;
import java.util.Arrays;

public class Boj_11404 {
    static final int INF = 100_000_000; // 충분히 큰 값으로 설정 (100,000 * 100까지 가능)
    static int[][] city;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); // 도시 개수
        m = sc.nextInt(); // 버스 개수
        
        // 비용 배열 초기화 (INF 값으로 설정)
        city = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(city[i], INF);
            city[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            
            city[a][b] = Math.min(city[a][b], cost); // 기존 값과 비교하여 최소 비용 저장
        }

        // 플로이드-워셜 알고리즘 수행
        floydWarshall();

        // 결과 출력
        printResult();
        
        sc.close();
    }

    // 플로이드-워셜 알고리즘
    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발 도시
                for (int j = 1; j <= n; j++) { // 도착 도시
                    if (city[i][k] != INF && city[k][j] != INF) { // 경유할 수 있는 경우
                        city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                    }
                }
            }
        }
    }

    // 결과 출력
    public static void printResult() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (city[i][j] == INF) {
                    System.out.print("0 "); // 도달할 수 없는 경우 0 출력
                } else {
                    System.out.print(city[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
