package confirm;

import java.util.List;

public class WinNumCheck2 {
	public static int run(int i, List<Integer> winNums, List<Integer> arr) {
		int answer = 0;
		for (int j = 0; j < 6; j++) {
			if (winNums.get(j) == arr.get(i)) {
				answer++;
			}
		}
		return answer;
	}
}
