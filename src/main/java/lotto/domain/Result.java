package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
	private static final Map<Rank, Integer> statistics;
	private static double profitRate;

	static {
		statistics = new HashMap<>();

		for (Rank prize : Rank.values()) {
			statistics.put(prize, 0);
		}
	}

	public static void calculateStatistics(List<Lotto> userLottos, List<Integer> winningLotto, int bonusNumber) {
		for (Lotto userLotto : userLottos) {
			int matchCount = userLotto.countMatchesWithWinningLotto(winningLotto, userLotto);
			boolean isMatchWithBonusNumber = userLotto.isMatchWithBonusNumber(bonusNumber, userLotto);

			calculateRank(matchCount, isMatchWithBonusNumber);
		}
	}

	private static void calculateRank(int matchCount, boolean isMatchWithBonusNumber) {
		if (matchCount == 6) {
			statistics.put(Rank.FIRST, statistics.get(Rank.FIRST) + 1);
			return;
		}

		if (matchCount == 5 && isMatchWithBonusNumber) {
			statistics.put(Rank.SECOND, statistics.get(Rank.SECOND) + 1);
			return;
		}

		if (matchCount == 5) {
			statistics.put(Rank.THIRD, statistics.get(Rank.THIRD) + 1);
			return;
		}

		if (matchCount == 4) {
			statistics.put(Rank.FOURTH, statistics.get(Rank.FOURTH) + 1);
			return;
		}

		if (matchCount == 3) {
			statistics.put(Rank.FIFTH, statistics.get(Rank.FIFTH) + 1);
			return;
		}
	}

	public static Integer getStatisticsByRank(Rank rank) {
		return statistics.get(rank);
	}

	public static void calculateProfitRate(int purchaseAmount) {
		int totalPrize = 0;

		for (Rank prize : Rank.values()) {
			totalPrize += prize.getWinningMoneyByRank() * statistics.get(prize);
		}

		profitRate = (double)totalPrize / purchaseAmount * 100;
	}

	public static double getProfitRate() {
		return profitRate;
	}

}
