package 소현.골드.발제.BOJ_9251;

import java.util.Scanner;

public class BOJ_9251 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		int[][] list = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					list[i][j] = list[i - 1][j - 1] + 1;
				} else {
					list[i][j] = Math.max(list[i - 1][j], list[i][j - 1]);
				}
			}

		}
		System.out.println(list[str1.length()][str2.length()]);

	}

}
