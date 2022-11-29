package confirm;

import java.util.List;

public class WinList {
	public static List<Integer> run(List<List<Integer>> playerPick, List<Integer> winNums) {
		List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0);
		for (int i = 0; i < playerPick.size(); i++) {
			int num = WinNumCheck.run(playerPick.get(i), winNums);
			answer = NumberInput.run(num, answer);
		}
		return answer;
	}
}
