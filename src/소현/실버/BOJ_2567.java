package 소현.실버;

import java.util.Scanner;

public class BOJ_2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] list = new int[100][100];
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int n = 0; n < 10; n++) {
				for (int m = 0; m < 10; m++) {
					list[a + n][b + m] = 1;
				}
			}

		}
		int ans = 0;
		for (int n = 0; n < 100; n++) {
			for (int m = 0; m < 100; m++) {
				if (list[n][m] == 1) {
					int share = 0;
					if (n + 1 < 100 && list[n + 1][m] == 1)
						share++;
					if (m + 1 < 100 && list[n][m + 1] == 1)
						share++;
					if (n - 1 >= 0 && list[n - 1][m] == 1)
						share++;
					if (m - 1 >= 0 && list[n][m - 1] == 1)
						share++;
					ans += (4 - share);
				}
			}
		}
		System.out.println(ans);

	}

}
