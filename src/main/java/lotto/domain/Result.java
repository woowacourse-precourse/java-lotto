package lotto.domain;

import static lotto.domain.constant.ResultConstant.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
	private static final List<Integer> statistics;
	private static final Map<Integer, Integer> prize;
	private static double profitRate;

	static {
		statistics = new ArrayList<>();
		prize = new HashMap<>();

		for (int i = 0; i <= RANKINGS; i++) {
			statistics.add(0);
		}

		prize.put(FIRST_PLACE, 2000000000);
		prize.put(SECOND_PLACE, 30000000);
		prize.put(THIRD_PLACE, 1500000);
		prize.put(FOURTH_PLACE, 50000);
		prize.put(FIFTH_PLACE, 5000);

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
			statistics.set(FIRST_PLACE, statistics.get(FIRST_PLACE) + 1);
			return;
		}

		if (matchCount == 5 && isMatchWithBonusNumber) {
			statistics.set(SECOND_PLACE, statistics.get(SECOND_PLACE) + 1);
			return;
		}

		if (matchCount == 5) {
			statistics.set(THIRD_PLACE, statistics.get(THIRD_PLACE) + 1);
			return;
		}

		if (matchCount == 4) {
			statistics.set(FOURTH_PLACE, statistics.get(FOURTH_PLACE) + 1);
			return;
		}

		if (matchCount == 3) {
			statistics.set(FIFTH_PLACE, statistics.get(FIFTH_PLACE) + 1);
			return;
		}
	}

	public static Integer getStatisticsByRank(int rank) {
		return statistics.get(rank);
	}

	public static void calculateProfitRate(int purchaseAmount) {
		int totalPrize = 0;

		for (int rank = 1; rank <= RANKINGS; rank++) {
			totalPrize += prize.get(rank) * statistics.get(rank);
		}

		profitRate = (double)totalPrize / purchaseAmount * 100;
	}

	public static double getProfitRate() {
		return profitRate;
	}

}
