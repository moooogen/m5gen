package 소현.골드;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_16236 {
	static int size, time, cnt, sharkSize, eatCnt, dist;
	static int[] posi;
	static int[][] list;
	static List<Integer[]> fish;
	static boolean canEatMore;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		size = sc.nextInt();
		time = 0;
		cnt = 0;
		eatCnt = 0;
		sharkSize = 2;
		posi = new int[2];
		list = new int[size][size];
		fish = new ArrayList<>();
		canEatMore = true;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				list[i][j] = sc.nextInt();
				if (list[i][j] == 9) {
					posi[0] = i;
					posi[1] = j;
					list[i][j] = 0;
				} else if (list[i][j] > 0) {
					cnt++;
				}
			}
		}
		while (cnt > 0) {
			check();
			if (!canEatMore) {
				break;
			}
		}
		System.out.println(time);

	}

	private static void check() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (list[i][j] > 0 && list[i][j] < sharkSize) {
					// x, y, 물고기크기
					dist = Integer.MAX_VALUE;
					check = new boolean[size][size];
					check[i][j] = true;
					getDist(i, j, 0);
					Integer[] newFish = { i, j, dist };
					fish.add(newFish);
				}
			}
		}

		if (fish.size() == 0) {
			canEatMore = false;
			return;
		}

		fish.sort((a, b) -> {
			if (a[2] != b[2])
				return a[2] - b[2];

			if (a[0] != b[0])
				return a[0] - b[0];

			return a[1] - b[1];
		});

		time += Math.abs(fish.get(0)[0] - posi[0]) + Math.abs(fish.get(0)[1] - posi[1]);
		posi[0] = fish.get(0)[0];
		posi[1] = fish.get(0)[1];
		list[fish.get(0)[0]][fish.get(0)[1]] = 0;
		eatCnt++;
		cnt--;
		fish.clear();
		if (eatCnt == sharkSize) {
			sharkSize++;
			eatCnt = 0;
		}

	}

	private static void getDist(int i, int j, int leng) {
		if (leng >= dist) {
			return;
		}
		if (i == posi[0] && j == posi[1]) {
			dist = leng;
			return;
		}
		if (i + 1 < size && list[i + 1][j] <= sharkSize && !check[i + 1][j]) {
			check[i + 1][j] = true;
			getDist(i + 1, j, leng + 1);
			check[i + 1][j] = false;
		}
		if (j + 1 < size && list[i][j + 1] <= sharkSize && !check[i][j + 1]) {
			check[i][j + 1] = true;
			getDist(i, j + 1, leng + 1);
			check[i][j + 1] = false;
		}
		if (i - 1 >= 0 && list[i - 1][j] <= sharkSize && !check[i - 1][j]) {
			check[i - 1][j] = true;
			getDist(i - 1, j, leng + 1);
			check[i - 1][j] = false;
		}
		if (j - 1 >= 0 && list[i][j - 1] <= sharkSize && !check[i][j - 1]) {
			check[i][j - 1] = true;
			getDist(i, j - 1, leng + 1);
			check[i][j - 1] = false;
		}

	}

}
