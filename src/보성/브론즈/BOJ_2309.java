import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Integer> list = new ArrayList<>();

		int sum = 0;

		for (int i = 0; i < 9; i++) {
			int input = sc.nextInt();
			list.add(input);
			sum += input;
		}

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - list.get(i) - list.get(j) == 100) {
					list.remove(j);
					list.remove(i);
					Collections.sort(list);
					for (int k = 0; k < list.size(); k++) {
						System.out.println(list.get(k));
					}
					return;
				}
			}
		}
	}
}