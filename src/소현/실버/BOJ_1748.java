package 소현.실버;

import java.util.Scanner;

public class BOJ_1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int leng = String.valueOf(num).length();
		int total = 0;

		total += (num * leng);

		for (int i = leng; i > 1; i--) {
			total -= (Math.pow(10, i - 1) - 1);
		}

		System.out.println(total);
	}

}
