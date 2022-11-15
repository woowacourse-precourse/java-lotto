package lotto.domain;

import java.util.Arrays;
import java.util.List;

import lotto.constant.WinningRating;

public class LottoComparator {
	private final WinningNumbers winningNumbers;
	private final BonusNumber bonusNumber;
	private WinningRating winningRating = WinningRating.MISS;

	LottoComparator(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public void compare(Lotto lotto) {
		boolean hasBonusNumber = checkHavingBonusNumber(lotto);
		int countOfMatchedNumber = calculateCountOfMatchedNumber(lotto.getNumbers());
		rateWinning(countOfMatchedNumber, hasBonusNumber);
	}

	private boolean checkHavingBonusNumber(Lotto lotto) {
		return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
	}

	private int calculateCountOfMatchedNumber(List<Integer> numbers) {
		return (int)numbers.stream().filter(winningNumbers.getWinningNumbers()::contains).count();
	}

	private void rateWinning(int countOfMatchedNumber, boolean hasBonusNumber) {
		Arrays.stream(WinningRating.values()).forEach(rating -> {
			if (rating.getCountOfMatchedNumber() == countOfMatchedNumber
				&& rating.getIsUsingBonusNumber() == hasBonusNumber)
				winningRating = rating;
		});
	}

	public WinningRating getWinningRating() {
		return winningRating;
	}
}