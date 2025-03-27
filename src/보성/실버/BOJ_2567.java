import java.util.Scanner;

public class BOJ_2567 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] board = new int[102][102];

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int r = x + 1; r < x + 11; r++) {
				for (int c = y + 1; c < y + 11; c++) {
					board[r][c] = 1;
				}
			}
		}

		int length = 0;
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (board[i][j] == 1) {
					int[] dr = { 0, 1, 0, -1 };
					int[] dc = { 1, 0, -1, 0 };
					for (int dir = 0; dir < 4; dir++) {
						if (board[i + dr[dir]][j + dc[dir]] == 0) {
							length++;
						}
					}
				}
			}
		}
		
		System.out.println(length);
	}
}
