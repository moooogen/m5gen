package 소현.브론즈;

import java.util.Scanner;

public class BOJ_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int ans = 1;
		int last = 1;

		if (num == ans) {
			System.out.println(ans);
			return;
		}
		while (true) {
			ans++;
			last += 6 * (ans - 1);
			if (num <= last) {
				System.out.println(ans);
				return;
			}

		}
	}

}
