package confirm;

import java.util.List;

public class WinList {
	public static List<Integer> run(List<List<Integer>> playerPick, List<Integer> winNums) {
		for (int i = 0; i < playerPick.size(); i++) {
			int num = WinNumCheck.run(playerPick.get(i), winNums);
			winNums.set(i, num);
		}
		return winNums;
	}
}
