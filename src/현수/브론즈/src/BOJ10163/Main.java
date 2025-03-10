package BOJ10163;
import java.util.*;
//색종이 : 메모리(25424 kb),시간(320 ms)
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[1001][1001];//0-1000까지
		
		for(int i=1; i<=n; i++) {
			int x = sc.nextInt();
			int y= sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			//덮어쓰기
			for(int k=x; k<x+w; k++) {
				for(int l=y; l<y+h; l++) arr[k][l] = i;
			}
		}
		//색종이 넓이, 숫자의 갯수로 넓이 계산
		int[] ans = new int[n];
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				if(arr[i][j] != 0) {//칸에서 보이는 색종이 종류가 있다면
					ans[arr[i][j]-1]++;
				}
			}
		}
		
		for(int i:ans) {
			System.out.println(i);
		}
	}

}
