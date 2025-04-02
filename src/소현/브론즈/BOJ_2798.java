package 소현.브론즈;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2798 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		int max = sc.nextInt();
		int ans = 0;
		int[] list = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			list[i] = sc.nextInt();
		}

		Arrays.sort(list);
		for (int a = cnt - 1; a > 1; a--) {
			next: for (int b = a - 1; b > 0; b--) {
				for (int c = b - 1; c >= 0; c--) {
					if (list[a] + list[b] + list[c] <= max) {
						if (ans < (list[a] + list[b] + list[c])) {
							ans = list[a] + list[b] + list[c];
							continue next;
						}
					}
				}

			}

		}
		System.out.println(ans);
	}
}
