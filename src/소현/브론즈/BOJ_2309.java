package 소현.브론즈;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	static boolean[] check;
	static int[] list;
	static boolean already = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new int[9];
		check = new boolean[9];

		for (int i = 0; i < 9; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		getAns(0, 0, 0);

	}

	private static void getAns(int idx, int cnt, int total) {
		if (already)
			return;
		if (cnt == 7 && total == 100) {
			for (int i = 0; i < 9; i++) {
				if (check[i]) {
					System.out.println(list[i]);
				}
			}
			already = true;
			return;
		}
		if (idx >= 9)
			return;
		if (idx - cnt < 2) {
			getAns(idx + 1, cnt, total);
		}
		check[idx] = true;
		getAns(idx + 1, cnt + 1, total + list[idx]);
		check[idx] = false;

	}

}
