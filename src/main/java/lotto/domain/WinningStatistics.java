package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import lotto.constant.WinningRating;

public class WinningStatistics {
	private static final int INITIAL_VALUE = 0;
	private static final int ADDED_COUNT = 1;

	private final List<Lotto> lotteries;
	private final WinningNumbers winningNumbers;
	private final BonusNumber bonusNumber;

	private EnumMap<WinningRating, Integer> countsOfWins;

	public WinningStatistics(List<Lotto> lotteries, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		this.lotteries = lotteries;
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
		collect();
	}

	private void collect() {
		init();
		calculateCountsOfWins();
	}

	private void init() {
		countsOfWins = new EnumMap<>(WinningRating.class);
		Arrays.stream(WinningRating.values()).forEach(rating -> countsOfWins.put(rating, INITIAL_VALUE));
	}

	private void calculateCountsOfWins() {
		LottoComparator lottoComparator = new LottoComparator(winningNumbers, bonusNumber);
		for (Lotto lotto : lotteries) {
			lottoComparator.compare(lotto);
			countsOfWins.computeIfPresent(lottoComparator.getWinningRating(),
				((winningRating, countOfWins) -> countOfWins + ADDED_COUNT));
		}
	}

	public EnumMap<WinningRating, Integer> getCountsOfWins() {
		return countsOfWins;
	}

}