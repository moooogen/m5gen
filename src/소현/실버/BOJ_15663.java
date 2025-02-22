package 소현.실버;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (9) : 중복되는 수열 출력 x 
public class BOJ_15663 {
	static int cnt, resCnt;
	static int[] list, ans;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		resCnt = sc.nextInt();
		list = new int[cnt];
		ans = new int[resCnt];
		check = new boolean[cnt];
		for (int i = 0; i < cnt; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		for (int i = 0; i < cnt; i++) {
			if (i > 0 && list[i] == list[i - 1]) {
				continue;
			}
			check[i] = true;
			ans[0] = list[i];
			getAns(1);
			check[i] = false;
		}

	}

	private static void getAns(int idx) {
		if (idx == resCnt) {
			for (int num : ans) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < cnt; i++) {
			if (i > 0 && list[i] == list[i - 1] && !check[i - 1]) {
				continue;
			}
			if (!check[i]) {
				check[i] = true;
				ans[idx] = list[i];
				getAns(idx + 1);
				check[i] = false;

			}
		}

	}
}
