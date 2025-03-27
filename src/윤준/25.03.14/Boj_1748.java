import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1748 {
	
	static int N, answer, lang, cal, log;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		answer = 0;
		
		String v = String.valueOf(N);
		
		dfs(N);
		
		
		System.out.println(answer);
	}
	static void dfs(int V) {
		String C = String.valueOf(V);
		lang = C.length();
		System.out.println(answer);
		if(V < 10) {
			answer += V;
			return;
		}
		
		if(V == log) {
			answer += lang;
		int U = log -1;
		dfs(U);
		}else {
			log = (int) Math.pow(10, lang-1);
			cal = V - log; 
			answer += cal * lang;
			dfs(log);
			}
	}
}

// ArrayList<String> num = new ArrayList<>();
// String num = " ";

//		    sb.append(i);  // 기존 문자열을 복사하지 않고 추가
//		for(int i = 1; i <= N; i++) {
//		String v = String.valueOf(i);
//		anwser += v.length();
//		}
//		System.out.println(sb.length());
//
//
//	}
//		Queue<String> num = new LinkedList<>();
//		for(int i = 1; i <= N; i++) {
//			String v = String.valueOf(i);
//			num.add(v);
//			num.poll();
//			answer += v.length();
//		}

//		