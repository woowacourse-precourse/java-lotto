package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import lotto.constant.WinningRating;
import lotto.util.Converter;

public class WinningStatisticsCompiler {
	private static final int INITIAL_VALUE = 0;
	private static final int ADDED_COUNT = 1;
	EnumMap<WinningRating, Integer> countsOfWins;
	List<Lotto> lotteries;
	int profit;
	WinningAndBonusNumbers winningAndBonusNumbers;

	public WinningStatisticsCompiler(List<Lotto> lotteries, WinningAndBonusNumbers winningAndBonusNumbers) {
		this.lotteries = lotteries;
		this.winningAndBonusNumbers = winningAndBonusNumbers;
		compile();
	}

	public EnumMap<WinningRating, Integer> getCountsOfWins() {
		return countsOfWins;
	}

	public int getProfit() {
		return profit;
	}
	private void compile() {
		init();
		calculateCountsOfWins();
		calculateProfit();
	}

	private void calculateProfit() {
		countsOfWins.forEach((winningRating, countOfWins) -> profit +=
			Converter.convertStringOfMoneyToLong(winningRating.getPrizeMoney()) * countOfWins);
	}

	private void init() {
		countsOfWins = new EnumMap<>(WinningRating.class);
		Arrays.stream(WinningRating.values()).forEach(rating -> countsOfWins.put(rating, INITIAL_VALUE));
	}

	private void calculateCountsOfWins() {
		LottoComparator lottoComparator = new LottoComparator(winningAndBonusNumbers);
		for (Lotto lotto : lotteries) {
			lottoComparator.compare(lotto);
			countsOfWins.computeIfPresent(lottoComparator.getWinningRating(),
				((winningRating, countOfWins) -> countOfWins + ADDED_COUNT));
		}
	}
}