package 소현.골드.발제.BOJ_17472;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 크루스칼 
public class Solution1 {
	static int x, y, idx, lendCnt;
	static int[][] map, checkLine;
	static boolean[][] check;
	static Queue<Integer> q;
	static int[] dy, dx, parent;

	static class Node {
		int from;
		int to;
		int leng;

		Node(int from, int to, int leng) {
			this.from = from;
			this.to = to;
			this.leng = leng;
		};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		y = sc.nextInt();
		x = sc.nextInt();

		dy = new int[] { -1, 1, 0, 0 };
		dx = new int[] { 0, 0, -1, 1 };

		map = new int[y][x];
		check = new boolean[y][x];
		q = new ArrayDeque<>();

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		idx = 1;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					q.add(i);
					q.add(j);
					check[i][j] = true;
					map[i][j] = idx;
					checkArea();
					idx++;
				}
			}
		}

		lendCnt = idx - 1;
		checkLine = new int[lendCnt][lendCnt];
		parent = new int[lendCnt];
		for (int i = 0; i < lendCnt; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (map[i][j] == 0)
					continue;
				int aLend = map[i][j] - 1;
				for (int k = 0; k < 4; k++) {
					int newY = i + dy[k];
					int newX = j + dx[k];
					if (newY < 0 || newX < 0 || newY >= y || newX >= x || map[newY][newX] != 0)
						continue;
					int leng = 0;
					while (newY < y && newX < x && newY >= 0 && newX >= 0 && map[newY][newX] == 0) {
						leng++;
						newY += dy[k];
						newX += dx[k];
					}
					if (leng < 2 || newY >= y || newX >= x || newY < 0 || newX < 0)
						continue;
					int bLend = map[newY][newX] - 1;

					checkLine[aLend][bLend] = checkLine[aLend][bLend] == 0 ? leng
							: Math.min(leng, checkLine[aLend][bLend]);
					checkLine[bLend][aLend] = checkLine[bLend][aLend] == 0 ? leng
							: Math.min(leng, checkLine[bLend][aLend]);
				}
			}
		}
		List<Node> linkedList = new ArrayList<>();
		for (int i = 0; i < lendCnt; i++) {
			for (int j = 0; j < lendCnt; j++) {
				if (checkLine[i][j] != 0) {
					linkedList.add(new Node(i, j, checkLine[i][j]));
				}
			}
		}
		int total = 0;
		int linkCnt = 1;
		Collections.sort(linkedList, (a, b) -> a.leng - b.leng);
		for (int i = 0; i < linkedList.size(); i++) {
			Node n = linkedList.get(i);
			if (find(parent[n.to]) != find(parent[n.from])) {
				union(parent[n.to], parent[n.from]);
				total += n.leng;
				linkCnt++;
			}
		}
		System.out.println(linkCnt == lendCnt ? total : -1);

	}

	private static void union(int i, int j) {
		i = find(i);
		j = find(j);

		if (i < j)
			parent[j] = i;
		else
			parent[i] = j;

	}

	private static int find(int i) {
		if (parent[i] == i)
			return i;
		else
			return find(parent[i]);
	}

	private static void checkArea() {
		while (!q.isEmpty()) {
			int a = q.poll();
			int b = q.poll();
			for (int i = 0; i < 4; i++) {
				int newY = a + dy[i];
				int newX = b + dx[i];
				if (newY < 0 || newX < 0 || newY >= y || newX >= x || check[newY][newX] || map[newY][newX] == 0)
					continue;
				q.add(newY);
				q.add(newX);
				check[newY][newX] = true;
				map[newY][newX] = idx;
			}

		}

	}

}
