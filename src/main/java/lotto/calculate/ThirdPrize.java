package calculate;

import java.util.List;

public class ThirdPrize {
	public static int run(List<Integer> correctNums) {
		int answer = 0;
		for (int i : correctNums) {
			if (i == 5) {
				answer++;
			}
		}
		System.out.println("5개 일치 (1,500,000원) - " + answer + "개");
		return answer * 1500000;
	}
}
