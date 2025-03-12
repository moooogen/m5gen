package 소현.브론즈;

import java.util.Scanner;

public class BOJ_10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		int[][] list = new int[1001][1001];

		int x, y, xLeng, yLeng;

		for (int i = 1; i <= cnt; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			xLeng = sc.nextInt();
			yLeng = sc.nextInt();

			for (int a = x; a < x + xLeng; a++) {
				for (int b = y; b < y + yLeng; b++) {
					list[a][b] = i;
				}
			}
		}

		int area;
		for (int i = 1; i <= cnt; i++) {
			area = 0;
			for (int a = 0; a < 1001; a++) {
				for (int b = 0; b < 1001; b++) {
					if (list[a][b] == i)
						area++;
				}

			}
			System.out.println(area);
		}
	}

}
