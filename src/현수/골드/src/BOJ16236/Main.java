package BOJ16236;
import java.util.*;
public class Main {
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		
		for(int i=0; i<n ; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
	}

}
