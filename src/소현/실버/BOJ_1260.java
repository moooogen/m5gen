package 소현.실버;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
	static int dot, line;
	static List<Integer>[] list;
	static boolean check[];
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dot = sc.nextInt();
		line = sc.nextInt();
		int start = sc.nextInt();
		list = new List[dot + 1];
		check = new boolean[dot + 1];
		q = new ArrayDeque<>();
		for (int i = 0; i < dot + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < line; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < dot + 1; i++) {
			Collections.sort(list[i]);
		}

		check[start] = true;
		dfs(start);
		System.out.println();
		check = new boolean[dot + 1];
		bfs(start);
	}

	private static void dfs(int num) {
		System.out.print(num + " ");
		for (int checkNum : list[num]) {
			if (!check[checkNum]) {
				check[checkNum] = true;
				dfs(checkNum);
			}
		}
	}

	private static void bfs(int start) {
		q.add(start);
		check[start] = true;

		while (!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num + " ");
			for (int checkNum : list[num]) {
				if (!check[checkNum]) {
					check[checkNum] = true;
					q.add(checkNum);
				}
			}
		}

	}

}
