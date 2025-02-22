package 소현.골드;

import java.util.Scanner;

// 평범한 배낭
public class BOJ_12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int maxW = sc.nextInt();
		int[][] list = new int[cnt][2];
		int[] value = new int[maxW + 1];
		for (int i = 0; i < cnt; i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
		}
		for (int j = 0; j < cnt; j++) {
			for (int i = maxW; i >= list[j][0]; i--) {
				if (value[i] < list[j][1] + value[i - list[j][0]]) {
					value[i] = (list[j][1] + value[i - list[j][0]]);
				}
			}
		}

		while (maxW > 0) {
			if (value[maxW] != 0) {
				System.out.println(value[maxW]);
				return;
			}
			maxW--;
			if (maxW == 0) {
				System.out.println(0);
				return;
			}
		}
	}

}
