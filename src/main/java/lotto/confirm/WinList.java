package confirm;

import java.util.ArrayList;
import java.util.List;

public class WinList {
	public static List<Integer> run(List<List<Integer>> playerPick, List<Integer> winNums) {
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < playerPick.size(); i++) {
			int num = WinNumCheck.run(playerPick.get(i), winNums);
			answer.set(i, num);
		}
		return answer;
	}
}
