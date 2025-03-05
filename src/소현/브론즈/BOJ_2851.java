package 소현.브론즈;

import java.util.Scanner;

public class BOJ_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] list = new int[10];
		int max = 0;
		for (int i = 0; i < 10; i++) {
			list[i] = sc.nextInt();
			if (list[i] + max < 100) {
				max += list[i];
			} else {
				int a = Math.abs(max - 100);
				int b = Math.abs(max + list[i] - 100);
				if (a < b) {
					System.out.println(max);
				} else {
					System.out.println(max + list[i]);
				}
				return;
			}
		}
		System.out.println(max);
	}

}
