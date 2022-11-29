package confirm;

import java.util.List;

public class BonusNumCheck2 {
	public static int run(List<Integer> winNums, List<Integer> arr) {
		int answer = 0;
		for (int j = 0; j < 6; j++) {
			if (winNums.get(j) == arr.get(6)) {
				answer+=10;
			}
		}
		return answer;
	}
}
