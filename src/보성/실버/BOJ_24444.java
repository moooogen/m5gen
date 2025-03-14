import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_24444 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();

		List<Integer>[] board = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			board[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N + 1];
		int[] ans = new int[N + 1];

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			board[from].add(to);
			board[to].add(from);
		}

		for (int i = 0; i < N + 1; i++) {
			Collections.sort(board[i]);
		}

//		for (int r = 0; r < N + 1; r++) {
//			System.out.print(r + " : ");
//			for (int c = 0; c < board[r].size(); c++) {
//				System.out.print(board[r].get(c) + " ");
//			}
//			System.out.println();
//		}

		int idx = 1;
		Queue<Integer> qu = new LinkedList<>();
		qu.add(start);
		visited[start] = true;
		ans[start] = idx++;

		while (!qu.isEmpty()) {
			int curr = qu.poll();
			for (int i = 0; i < board[curr].size(); i++) {
				if (!visited[board[curr].get(i)]) {
					visited[board[curr].get(i)] = true;
					qu.add(board[curr].get(i));
					ans[board[curr].get(i)] = idx++;
				}
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			System.out.println(ans[i]);
		}
	}
}
