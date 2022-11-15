package calculate;

import java.util.List;

public class SecondPrize {
	public static int run(List<Integer> correctNums) {
		int answer = 0;
		for (int i : correctNums) {
			if (i == 15) {
				answer++;
			}
		}
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -" + answer + "개");
		return answer * 30000000;
	}
}
