/*
3
3 7
15 7
5 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_2563 {
	static int row, cal;
	static boolean visited[][];
	static int map[][];
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		row = 0;
		cal = 0;
		count = 0;
		
		int[][] dot = new int[N+1][3]; //1부터 시작하려고 N+1 , 3 설정
		
		for(int i = 1; i < N+1; i++) {
			dot[i][1] = sc.nextInt();
			dot[i][2] = sc.nextInt();
			
			if(row < dot[i][1]+10) {
				row = dot[i][1]+10;
			}
			if(cal < dot[i][2]+10) {
				cal = dot[i][2]+10;
			}
		}
		System.out.println(row);
		System.out.println(cal);
		
		visited = new boolean[row+1][cal+1];
		map = new int[row+1][cal+1];
		
		for(int k = 1; k < N+1; k++) {
			for(int i = dot[k][1]; i < dot[k][1]+10; i++) {
				for(int j = dot[k][2]; j < dot[k][2] +10; j++) {
					map[i][j] = 1;
				}
			}
			
		}

		for(int i = 1; i < row+1; i++) {
			for(int j = 1; j < cal+1; j++) {
				if(map[i][j] == 1) {
					count++;
			}
		}
			}
		
	
		System.out.println(count);
	}

}
