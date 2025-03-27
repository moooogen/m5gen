import java.util.Scanner;

public class Boj_2567_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		int[] dx = {0, -1, 0, 1};
		int[] dy = {1, 0, -1, 0};
		
		
		for(int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int start2 = sc.nextInt();
			
			for(int a = start; a < start +10; a++) {
				for(int b = start2; b < start2 +10; b++) {
					map[a][b] = 1;
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j =0; j < 100; j++) {
				if(map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100 || map[nx][ny] == 0) {
                            count++;
				}
			}
		}
		

	}
}
		System.out.println(count);
	}
}
