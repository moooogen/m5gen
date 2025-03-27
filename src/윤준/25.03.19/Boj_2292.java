import java.util.Scanner;

public class Boj_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int B = 0; 
		 int C = 0;
		 int D = 0;
		 
		 while( N > C) {
			if(N == 1) {
				D = 1;
				break;
			}
			C = 1 + 6 * B; 
			D++;
			B += D;
		 }

		 System.out.println(D);
	}

}
