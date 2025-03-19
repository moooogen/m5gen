package BOJ2292;
import java.util.*;
/* 벌집 : 메모리(17684 kb), 시간(176 ms)
 * 출력 : 1을 기준으로 껍데기라고 생각하기
 * 중앙=1
 * 첫번째 껍질의 숫자 범위 : 2-7까지 6*1개
 * 2 = 8-19까지 6*2개
 * 방문하는 방 =  껍질 + 1
 */

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean check = false;
		int s = 1;
		int idx = 1;
		int ans = 0;
		int end = 7; //첫번째 껍질의 end값
		
		// 1은 고려하지 못함
		while(!check && n!=1) {
			if(s<= n && n<= end) {
				//범위 안에 있으면 탈출
				ans = idx+1;
				check = true;
			}
			else {
				s = end + 1;
				idx++;
				end += 6*idx;
			}
			
		}
		if(n==1) System.out.println(1);
		else System.out.println(ans);
		
		
		
	}

}
