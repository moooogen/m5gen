package BOJ1748;
import java.util.*;
// 수 이어쓰기 1 : 메모리(17668 kb), 시간(320 ms)
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int len = 1;
		int start = 1;
		int cnt =0;
		
		for(int i=1; i<=n ; i++) {
			if(i == start * 10) {
				len++;
				start = start * 10;
			}
			cnt += len;
		}
		System.out.println(cnt);
	}
}
