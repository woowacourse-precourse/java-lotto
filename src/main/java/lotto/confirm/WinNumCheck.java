package confirm;

import java.util.List;

public class WinNumCheck {
	public static int run(List<Integer> arr, List<Integer> winNums) {
		int answer = 0;
		for (int i = 0; i < 6; i++) {
			answer += WinNumCheck2.run(i, winNums, arr);
		}
		if (answer == 5) {
			BonusNumCheck.run(answer, arr, winNums);
		}
		return answer;
	}
}
