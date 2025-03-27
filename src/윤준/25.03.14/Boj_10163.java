import java.util.Scanner;

public class Boj_10163 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[1001][1001];
		
		
		for(int k = 1; k <= N; k++) {
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		for(int i = a; i < a + c; i++) {
			for(int j = b; j < b + d; j++) {
				map[i][j] = k;
			}
		}
		
		
		}
		
		for(int k = 1; k <= N; k++) {
			int count = 0;
		for(int i= 0 ; i < 1001; i++) {
			for(int j= 0; j < 1001; j++) {
				if(map[i][j] == k) {
					count++;
				}
			}
		}
		System.out.println(count);
		}
		

	}

}
