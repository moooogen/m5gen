package 소현.골드;

import java.util.Scanner;

// 플로이드 워셜 ver
public class BOJ_11404 {
	static boolean[] check;
	static int[][] list;
	static int cityCnt, busCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cityCnt = sc.nextInt();
		busCnt = sc.nextInt();

		list = new int[cityCnt][cityCnt];
		check = new boolean[cityCnt];

		int maxVal = Integer.MAX_VALUE;

		for (int i = 0; i < cityCnt; i++) {
			for (int j = 0; j < cityCnt; j++) {
				list[i][j] = maxVal;
			}
		}

		for (int i = 0; i < busCnt; i++) {
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;
			int cost = sc.nextInt();
			if (list[start][end] > cost) {
				list[start][end] = cost;
			}
		}

		for (int k = 0; k < cityCnt; k++) {
			// 출발지
			for (int i = 0; i < cityCnt; i++) {
				// 도착지
				for (int j = 0; j < cityCnt; j++) {
					if (list[i][k] + list[k][j] > 0) {
						list[i][j] = Math.min(list[i][j], list[i][k] + list[k][j]);

					}
				}
			}
		}
		for (int i = 0; i < cityCnt; i++) {
			for (int j = 0; j < cityCnt; j++) {
				if (i == j) {
					System.out.print(0);
				} else {
					System.out.print(list[i][j] == maxVal ? 0 : list[i][j]);

				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
