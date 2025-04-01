import java.util.Scanner;

public class Boj_2798 {
	
	static int N,M,minimum,answer;
	static int num[];
	static int black[];
	static boolean visited[];
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		minimum = Integer.MAX_VALUE;
		answer = 0;
		
		num = new int[N];
		black = new int[3];
		
		for(int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		System.out.println(answer);

	}
	static void dfs(int start , int depth) {
		if(depth == 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += black[i];
			}
			if(sum <= M) {
			int min = Math.abs(M - sum); 
			if(min < minimum) {
				minimum = min;
				answer = sum;
				if (minimum == 0) {
					return;
				}
			}
			}
			return;
		}
		 for (int i = start; i < N; i++) {
	            black[depth] = num[i];
	            dfs(i + 1, depth + 1);
	}
}
}
