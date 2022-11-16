package lotto.domain.lotteryserver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningChecker {
	public static List<Rank> getStatistics(List<List<Integer>> lottoSets,
		List<Integer> winningNumbers, int bonusNumber) {
		List<Rank> statisticsResults = new ArrayList<>();

		for (List<Integer> lottoSet : lottoSets) {
			statisticsResults.add(countMatchedNumber(lottoSet, winningNumbers, bonusNumber));
		}

		return statisticsResults;
	}

	public static String getProfit(List<Rank> winningStatistics, int money) {
		int totalPrizeMoney = 0;

		for (Rank prize : winningStatistics) {
			totalPrizeMoney += prize.getPrizeMoney();
		}

		float beforeRoundUp = ((float) totalPrizeMoney / money) * 100;
		float afterRoundUp = Math.round(beforeRoundUp * 10) / 10.0f;

		return String.format("%.1f", afterRoundUp);
	}

	private static Rank countMatchedNumber(List<Integer> lottoSet, List<Integer> winningNumbers,
		int bonusNumber) {
		int matchedCount;

		List<Integer> counter = lottoSet.stream()
			.filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
			.collect(Collectors.toList());
		matchedCount = counter.size();

		return getMatchedRankMoney(lottoSet, bonusNumber, matchedCount);
	}

	private static Rank getMatchedRankMoney(List<Integer> lottoSet, int bonusNumber,
		int matchedCount) {
		boolean bonusFlag = isBonus(lottoSet, bonusNumber);
		return Rank.getRank(matchedCount, bonusFlag);
	}

	private static boolean isBonus(List<Integer> lottoSet, int bonusNumber) {
		Stream<Integer> setNumbers = lottoSet.stream();
		return setNumbers.anyMatch(elem -> elem == bonusNumber);
	}
}
