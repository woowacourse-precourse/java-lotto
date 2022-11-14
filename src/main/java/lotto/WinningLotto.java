package lotto;

import java.util.HashMap;
import java.util.List;

public class WinningLotto {
	static HashMap<Integer, Integer> result = new HashMap<>();
	static int matchCount = 0;
	static boolean isMatchBonusNumber = false;
	private static List<Integer> winningLotto;
	private static int bonusNumber;

	public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
		initResult();
	}

	private static void initResult() {
		result.put(3, 0);
		result.put(4, 0);
		result.put(5, 0);
		result.put(6, 0);
	}

	public static HashMap<Integer, Integer> produceResult(List<List<Integer>> lotteryTickets) {
		for (List<Integer> lotteryTicket : lotteryTickets) {
			Comparison comparison = new Comparison(WinningLotto.winningLotto, WinningLotto.bonusNumber);
			matchCount = comparison.matchLottoCount(lotteryTicket);
			isMatchBonusNumber = comparison.isMatchBonusNumber(lotteryTicket);

			Rank rank = Rank.setRank(matchCount, isMatchBonusNumber);
			int key = rank.getMatchCount();
			result.put(key, result.getOrDefault(key, 0) + 1);
		}
		return result;
	}
}
