package 소현.실버;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int dotCnt = sc.nextInt();
		int lineCnt = sc.nextInt();
		boolean[] check = new boolean[dotCnt];

		List<Integer>[] list = new ArrayList[dotCnt];
		for (int i = 0; i < dotCnt; i++) {
			list[i] = new ArrayList<>();
		}
		Queue<Integer> q = new ArrayDeque<>();

		int a, b;
		int total = 0;

		for (int i = 0; i < lineCnt; i++) {
			a = sc.nextInt() - 1;
			b = sc.nextInt() - 1;
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < dotCnt; i++) {
			if (!check[i]) {
				q.add(i);
				check[i] = true;
				total++;
				while (!q.isEmpty()) {
					int checkDot = q.poll();
					for (int num : list[checkDot]) {
						if (!check[num]) {
							q.add(num);
							check[num] = true;
						}
					}
				}
			}
		}
		System.out.println(total);

	}

}
