package BOJ2567;
import java.util.Scanner;
//색종이 : 메모리(17896), 시간(180)
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] paper = new int[101][101]; // 도화지: 0 ~ 100까지 사용 가능

        // 색종이 붙이기
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 색종이는 (x, y)부터 (x+9, y+9)까지
            for (int dx = 0; dx < 10; dx++) {
                for (int dy = 0; dy < 10; dy++) {
                    paper[x + dx][y + dy] = 1;
                }
            }
        }

        int perimeter = 0;

        // 4방향 델타 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 모든 셀을 순회하면서 둘레 계산
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (paper[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];

                        // 경계 밖이거나 인접한 칸이 흰색(0)이라면 둘레에 포함
                        if (ni < 0 || nj < 0 || ni > 100 || nj > 100 || paper[ni][nj] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        System.out.println(perimeter);
    }
}
