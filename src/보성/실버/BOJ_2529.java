import java.util.Scanner;

public class BOJ_2529 {

	static int k;
	static int[] ans;
	static boolean[] sign, visited;
	static String[] ansString;
	static boolean first;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();

		sign = new boolean[k];

		for (int i = 0; i < k; i++) {
			sign[i] = sc.next().charAt(0) == '<' ? true : false;
		}

		ans = new int[k + 1];
		visited = new boolean[10];
		ansString = new String[2];
		ansString[0] = "";
		ansString[1] = "";
		first = true;
		fill(0);
		System.out.println(ansString[1]);
		System.out.println(ansString[0]);
	}

	static void fill(int idx) {
		if (idx == k + 1) {
			if (first) {
				String temp = "";
				for (int i = 0; i < ans.length; i++) {
					temp += ans[i];
				}
				ansString[0] = temp;
				first = false;
			}
			String temp = "";
			for (int i = 0; i < ans.length; i++) {
				temp += ans[i];
			}
			ansString[1] = temp;
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				if (idx == 0) {
					ans[idx] = i;
					visited[i] = true;
					fill(idx + 1);
					visited[i] = false;
				} else if (sign[idx - 1]) {
					if (i > ans[idx - 1]) {
						ans[idx] = i;
						visited[i] = true;
						fill(idx + 1);
						visited[i] = false;
					}
				} else if (!sign[idx - 1]) {
					if (i < ans[idx - 1]) {
						ans[idx] = i;
						visited[i] = true;
						fill(idx + 1);
						visited[i] = false;
					}
				}
			}
		}
	}
}
