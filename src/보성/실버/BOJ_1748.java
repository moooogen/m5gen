import java.util.Scanner;

public class BOJ_1748 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int a = (int) Math.log10(N);
		int ans = 0;

		for (int i = 1; i <= a; i++) {
			ans += i * 9 * Math.pow(10, i - 1);
		}
		ans += (N - Math.pow(10, a) + 1) * (a + 1);

		System.out.println(ans);
	}
}
/*
 * 1~9: 1*9, 10~99: 2*90, 100~999: 3*900
 */