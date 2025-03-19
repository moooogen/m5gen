import java.util.Scanner;

public class BOJ_2292 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double N = sc.nextDouble();
		int ans = (int) ((3 + Math.sqrt(12 * (N - 1) - 3)) / 6) + 1;
		System.out.println(ans);
	}
}
/*
 * ~6*(n*(n-1)/2)+1 : n
 */