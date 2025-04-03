package 소현.골드.발제.BOJ_9251;

import java.util.Scanner;

public class BOJ_9251_ver2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		int[] list1 = new int[str2.length() + 1];
		int[] list2 = new int[str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				list1[j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? list2[j - 1] + 1 : Math.max(list1[j], list1[j - 1]);
			}
			list2 = list1.clone();

		}
		System.out.println(list1[str2.length()]);
	}

}
