import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] board = new int[N][M];

		for (int r = 0; r < N; r++) {
			String temp = sc.next();
			for (int c = 0; c < M; c++) {
				board[r][c] = (int) temp.charAt(c) - '0';
			}
		}

		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] { 0, 0, 1 });
		board[0][0] = 0;

		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 1) {
					if (nr == N - 1 && nc == M - 1) {
						System.out.println(curr[2] + 1);
						return;
					}
					qu.add(new int[] { nr, nc, curr[2] + 1 });
					board[nr][nc] = 0;
				}
			}
		}
	}
}
