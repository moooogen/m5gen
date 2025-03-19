import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
	static List<Integer>[] board;
	static boolean[] visited;
	static List<Integer> ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		board = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			board[i] = new ArrayList();
		}
		visited = new boolean[N + 1];
		ans = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			board[from].add(to);
			board[to].add(from);
		}
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(board[i]);
		}
		DFS(V);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
		ans = new ArrayList<>();
		visited = new boolean[N + 1];
		BFS(V);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	static void DFS(int num) {
		visited[num] = true;
		ans.add(num);
		for (int i = 0; i < board[num].size(); i++) {
			if (!visited[board[num].get(i)]) {
				DFS(board[num].get(i));
			}
		}
	}

	static void BFS(int num) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(num);
		visited[num] = true;
		ans.add(num);
		while (!qu.isEmpty()) {
			int curr = qu.poll();
			for (int i = 0; i < board[curr].size(); i++) {
				if (!visited[board[curr].get(i)]) {
					visited[board[curr].get(i)] = true;
					ans.add(board[curr].get(i));
					qu.add(board[curr].get(i));
				}
			}
		}
	}
}
