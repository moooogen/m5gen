package 소현.골드;

import java.util.Scanner;

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

		for (int i = 0; i < busCnt; i++) {
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;
			int cost = sc.nextInt();
			if (list[start][end] == 0 || list[start][end] > cost) {
				list[start][end] = cost;
			}
		}
		for (int start = 0; start < cityCnt; start++) {
			for (int end = 0; end < cityCnt; end++) {
				if (start == end)
					continue;
				for (int next = 0; next < cityCnt; next++) {
					if (next == start || next == end || list[start][next] == 0)
						continue;
					check[next] = true;
					getAns(start, end, next, list[start][next]);
					check[next] = false;
				}
			}
		}
		for (int i = 0; i < cityCnt; i++) {
			for (int j = 0; j < cityCnt; j++) {
				if (i == j) {
					System.out.print(0);
				} else {
					System.out.print(list[i][j]);

				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void getAns(int start, int end, int next, int value) {
		if (list[start][end] != 0 && value >= list[start][end])
			return;
		if (end == next) {
			if (list[start][end] == 0 || list[start][end] > value) {
				list[start][end] = value;
			}
			return;
		}

		for (int i = 0; i < cityCnt; i++) {
			if (list[next][i] == 0 || check[i] || i == start) {
				continue;
			}
			check[i] = true;
			getAns(start, end, i, value + list[next][i]);
			check[i] = false;
		}
	}

}
