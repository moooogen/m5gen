import java.util.Scanner;

public class BOJ_11724 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] p = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			int main = p[u];
			int sub = p[v];
			
			for (int j = 0; j < N + 1; j++) {
				if (p[j] == sub) {
					p[j] = main;
				}
			}
		}
		
		int ans = 0;
		
		for (int i = 1; i < N + 1; i++) {
			if (p[i] == i) ans++;
		}

		System.out.println(ans);
	}
}
