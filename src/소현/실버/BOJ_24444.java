package 소현.실버;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_24444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pointCnt = sc.nextInt();
		int lineCnt = sc.nextInt();
		int start = sc.nextInt() - 1;
		int[] check = new int[pointCnt];
		List<Integer>[] list = new List[pointCnt];
		for (int i = 0; i < pointCnt; i++) {
			list[i] = new ArrayList<>();
			check[i] = -1;
		}
		int turn = 1;
		for (int i = 0; i < lineCnt; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < pointCnt; i++) {
			list[i].sort((a, b) -> a - b);
		}
		Queue<Integer> q = new ArrayDeque<>();
		check[start] = turn++;
		q.add(start);
		while (!q.isEmpty()) {
			int num = q.poll();
			for (int newNum : list[num]) {
				if (check[newNum] == -1) {
					q.add(newNum);
					check[newNum] = turn++;
				}
			}
		}
		for (int i = 0; i < pointCnt; i++) {
			if (check[i] == -1) {
				System.out.println(0);
			} else {
				System.out.println(check[i]);
			}
		}
	}

}
