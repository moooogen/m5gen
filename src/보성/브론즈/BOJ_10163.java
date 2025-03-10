import java.util.Scanner;

public class BOJ_10163 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] board = new int[1001][1001];
		int[] ans = new int[N];

		for (int i = 0; i < N; i++) {
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for (int r = startR; r < startR + width; r++) {
				for (int c = startC; c < startC + height; c++) {
					board[r][c] = i + 1;
				}
			}
		}

		for (int r = 0; r < 1001; r++) {
			for (int c = 0; c < 1001; c++) {
				if (board[r][c] > 0) {
					ans[board[r][c] - 1]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(ans[i]);
		}
	}
}
