package player;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayerChoose {
	public static List<List<Integer>> run(int chance) {
		List<List<Integer>> playerNumbers = new ArrayList<>();
		for (int i = 0; i < chance; i++) {
			List<Integer> arr = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			playerNumbers.add(arr);
			ShowNums.run(arr);
		}		
		return playerNumbers;
	}
}
