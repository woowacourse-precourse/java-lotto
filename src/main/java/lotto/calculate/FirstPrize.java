package calculate;

import java.util.List;

public class FirstPrize {
	public static int run(List<Integer> correctNums) {
		int answer = 0;
		for (int i : correctNums) {
			if (i == 6) {
				answer++;
			}
		}
		System.out.println("6개 일치 (2,000,000,000원) - " + answer + "개");
		return answer * 2000000000;
	}
}
