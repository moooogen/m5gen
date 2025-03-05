package 소현.실버;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
	static int numCnt, wantCnt;
	static int[] numList, ansList;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numCnt = sc.nextInt();
		wantCnt = sc.nextInt();
		numList = new int[numCnt];
		ansList = new int[wantCnt];
		check = new boolean[numCnt];
		for (int i = 0; i < numCnt; i++) {
			numList[i] = sc.nextInt();
		}
		Arrays.sort(numList);
		for (int i = 0; i < numCnt; i++) {
			check[i] = true;
			ansList[0] = numList[i];
			getAns(1);
			check[i] = false;
		}

	}

	private static void getAns(int idx) {
		if (idx == wantCnt) {
			for (int num : ansList) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < numCnt; i++) {
			if (!check[i]) {
				check[i] = true;
				ansList[idx] = numList[i];
				getAns(idx + 1);
				check[i] = false;
			}
		}
	}

}
