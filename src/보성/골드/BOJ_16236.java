import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16236 {

	static int N;
	static int size = 2;
	static int[][] board;
	static int[] shark;
	static List<int[]> fish;
	static boolean[][] visited;
	static int eatCount, ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		board = new int[N][N];
		visited = new boolean[N][N];
		shark = new int[2];
		fish = new ArrayList<>();
		eatCount = 0;
		ans = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = sc.nextInt();
				if (board[r][c] == 9) {
					shark[0] = r;
					shark[1] = c;
					board[r][c] = 0;
				}
			}
		}

		BFS(shark[0], shark[1]);
		System.out.println(ans);
	}

	static void BFS(int r, int c) {
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] { r, c, 0 });
		visited[r][c] = true;
		int min = Integer.MAX_VALUE;

		to: while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && board[nr][nc] <= size) {
					qu.add(new int[] { nr, nc, curr[2] + 1 });
					visited[nr][nc] = true;
					if (board[nr][nc] != 0 && board[nr][nc] < size) {
						if (curr[2] + 1 > min) {
							break to;
						}
						fish.add(new int[] { nr, nc, curr[2] + 1 });
						min = curr[2] + 1;
					}
				}
			}
		}

		if (fish.size() > 0) {
			Collections.sort(fish, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}
			});
			shark[0] = fish.get(0)[0];
			shark[1] = fish.get(0)[1];
			board[shark[0]][shark[1]] = 0;
			eatCount++;
			if (eatCount == size) {
				size++;
				eatCount = 0;
			}
			ans += fish.get(0)[2];
			visited = new boolean[N][N];
			fish = new ArrayList<>();
			BFS(shark[0], shark[1]);
		}
	}
}
