package calculate;

import java.util.List;

public class FourthPrize {
	public static int run(List<Integer> correctNums) {
		int answer = 0;
		for (int i : correctNums) {
			if (i == 4) {
				answer++;
			}
		}
		System.out.println("4개 일치 (50,000원) - " + answer + "개");
		return answer * 50000;
	}
}
