package BOJ2477;
//2차원 배열을 이용 (평범한배낭)
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[][] = new int[n+1][2]; //arr[i][0] = i번째 물건의 무게, //arr[i][0] = i번째 물건의 가치
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<2;j++) {arr[i][j] = sc.nextInt();}
		}
		
		int dp[][] = new int[k+1][n+1] ; //k무게 도달까지 하나씩은 넣을 수 있을 때 무조건 넣고의 최대 가치
		
		for(int w=1; w<=k ; w++) {//1키로부터 값 채우기
			for(int thing=1; thing<=n; thing++) {//1번째 포함 최대가치 , 2번째 포함 최대가치,,,이렇게 구함
				if(arr[thing][0]<=w) {//thing을 포함했을 때 무게, 해당 무게가 빠졌을 때 (w-thing 무게) 최대가치 + 현재 가치
					dp[w][thing] = Math.max((dp[w-arr[thing][0]][thing-1] + arr[thing][1]), dp[w][thing-1]);
				}
				else {//넣을 수 없는 무게일때는 직전값
					dp[w][thing] = dp[w][thing-1];	
				}	
			}
		}
		System.out.println(dp[k][n]);
	}

}
