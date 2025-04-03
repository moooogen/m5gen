package 소현.실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2529 {
	static int cnt;
	static int[] numCheck;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cnt = sc.nextInt();
		String[] list = new String[cnt];
		for(int i=0; i<cnt; i++) {
			list[i] = sc.next();
		}

		numCheck = new int[10];
		for (int i = 0; i < 10; i++) {
			numCheck[i] = -1;
		}
		int num = 9;
		while (num >= 9 - cnt) {
			int idx = 0;
			
		}
		for (int i = 0; i <= cnt; i++) {
			System.out.print(numCheck[i]);
		}
		System.out.println();
//		num = 0;
//		for (int i = 0; i < 10; i++) {
//			numCheck[i] = -1;
//		}
//		while (num <= cnt) {
//
//		}
//
//		for (int i = 0; i <= cnt; i++) {
//			System.out.print(numCheck[i]);
//		}
	}

}
