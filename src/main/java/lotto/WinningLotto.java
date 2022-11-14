package lotto;

import java.util.HashMap;
import java.util.List;

public class WinningLotto {
	static HashMap<String, Integer> result = new HashMap<>();
	static int matchCount = 0;
	static boolean isMatchBonusNumber = false;
	private static List<Integer> winningLotto;
	private static int bonusNumber;

	public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
	}

	public static HashMap<String, Integer> produceResult(List<List<Integer>> lotteryTickets) {
		for (List<Integer> lotteryTicket : lotteryTickets) {
			Comparison comparison = new Comparison(WinningLotto.winningLotto, WinningLotto.bonusNumber);
			matchCount = comparison.matchLottoCount(lotteryTicket);
			isMatchBonusNumber = comparison.isMatchBonusNumber(lotteryTicket);
			if (matchCount == 6) {
				result.put("First", result.getOrDefault("First", 0) + 1);
			}
			if (matchCount == 5 && isMatchBonusNumber) {
				result.put("Second", result.getOrDefault("Second", 0) + 1);
			}
			if (matchCount == 5 && !isMatchBonusNumber) {
				result.put("Third", result.getOrDefault("Third", 0) + 1);
			}
			if (matchCount == 4) {
				result.put("Fourth", result.getOrDefault("Fourth", 0) + 1);
			}
			if (matchCount == 3) {
				result.put("Fifth", result.getOrDefault("Fifth", 0) + 1);
			}
		}
		return result;
	}
}
