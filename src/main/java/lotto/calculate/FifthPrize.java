package calculate;

import java.util.List;

public class FifthPrize {
	public static int run(List<Integer> correctNums) {
		int answer = 0;
		for (int i : correctNums) {
			if (i == 3) {
				answer++;
			}
		}
		System.out.println("3개 일치 (5,000원) - " + answer + "개");
		return answer * 5000;
	}
}
