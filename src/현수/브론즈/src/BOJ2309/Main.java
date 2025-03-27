package BOJ2309;
import java.util.*;
//일곱난쟁이 메모리(17684), 시간(172)

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i=0; i<9; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int total =0;
		for (int i : arr) total += i;
		int dum = total - 100;
		
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i != j) {
					if(arr[i]+arr[j] == dum) {
						for (int k=0; k<9; k++) {
							if(k==i || k==j) continue;
							else System.out.println(arr[k]);
						}
						return;
					}
				}
				
			}
		}
		
		
	}

}
