import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2178 {

	static int N,M,count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		count = 0;
		
		String num = "";
		
		for(int i= 0 ; i < N; i++) {
			num += sc.next();
		}
		
		int o = 0;
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = num.charAt(o)-'0';
				o++;
			}
		}
			
			bfs();
			
			System.out.println(map[N-1][M-1]);
	}
	
	
	static void bfs() {
		Queue <int[]> qu = new LinkedList<>();
		qu.add(new int[]{0,0});
		map[0][0] = 1;
		visited[0][0] = true;

		while(!qu.isEmpty()) {
		
			int[] curr = qu.poll();
			
			int x  = curr[0];
			int y  = curr[1];
			
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					qu.add(new int[] {nx,ny});
					map[nx][ny] = map[x][y] + 1;
					}
				}
		}
	}
}