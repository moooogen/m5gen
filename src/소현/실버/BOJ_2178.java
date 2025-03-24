package 소현.실버;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nr = { 0, 0, -1, 1 };
		int[] nc = { 1, -1, 0, 0 };
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] list = new char[n][m];
		for (int i = 0; i < n; i++) {
			list[i] = sc.next().toCharArray();
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		q.add(0);
		q.add(1);

		int a, b, now;
		while (!q.isEmpty()) {
			a = q.poll();
			b = q.poll();
			now = q.poll();
			if (a == n - 1 && b == m - 1) {
				System.out.println(now);
				break;
			}
			for (int i = 0; i < 4; i++) {
				if (a + nc[i] >= 0 && a + nc[i] < n && b + nr[i] >= 0 && b + nr[i] < m
						&& list[a + nc[i]][b + nr[i]] == '1') {
					list[a + nc[i]][b + nr[i]] = '0';
					q.add(a + nc[i]);
					q.add(b + nr[i]);
					q.add(now + 1);
				}

			}
		}
	}

}
