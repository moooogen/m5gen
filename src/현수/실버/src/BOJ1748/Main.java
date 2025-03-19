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
			//자리수가 변하는 조건 (10일때 100일때 1000일때로 봄)
			if(i == start * 10) { 
				//10, 100 이때가 자리수가 1->2 , 2-> 3자리 수가 됨
				len++; //자리수 len을 늘리고 1-2-3- ...
				start = start * 10; // 다음 스타트 값을 10-> 100->1000으로 늘림
			}
			cnt += len;// 자리수 늘림
		}
		System.out.println(cnt);
	}
}
