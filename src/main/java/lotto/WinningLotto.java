package lotto;

import java.util.HashMap;
import java.util.List;

public class WinningLotto {
	public static HashMap<String, Integer> produceResult(List<List<Integer>> lotteryTickets) {
		HashMap<String, Integer> result = new HashMap<>();
		result.put("First", 1);
		result.put("Second", 1);
		result.put("Third", 1);
		result.put("Fourth", 1);
		result.put("Fifth", 1);
		return result;
	}
}
