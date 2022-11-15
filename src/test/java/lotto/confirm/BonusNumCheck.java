package confirm;

import java.util.List;

public class BonusNumCheck {
	public static int run(int answer, List<Integer> arr, List<Integer> winNums) {
		answer += BonusNumCheck2.run(winNums, arr);
		return answer;
	}
}
