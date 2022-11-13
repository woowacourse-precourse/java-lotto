package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.constant.LottoConstant;
import lotto.constant.WinningRating;

public class LottoComparator {
	Lotto lotto;
	WinningAndBonusNumbers winningAndBonusNumbers;
	List<Integer> winningNumbers;
	List<Integer> winningNumbersWithBonusNumber;
	int bonusNumber;
	int countOfMatchedNumber;
	WinningRating winningRating;

	LottoComparator(WinningAndBonusNumbers winningAndBonusNumbers) {
		this.winningAndBonusNumbers = winningAndBonusNumbers;
	}

	public WinningRating getWinningRating() {
		return winningRating;
	}

	public void compare(Lotto lotto) {
		this.lotto = lotto;

		init();
		calculateCountOfMatchedNumber();
		rateWinning();
	}

	private void rateWinning() {
		if (countOfMatchedNumber >= WinningRating.FIFTH.getCountOfMatchedNumber()) {
			rateWinningWithoutBonusNumber();
		}
		if (countOfMatchedNumber == WinningRating.SECOND.getCountOfMatchedNumber()) {
			rateWinningWithBonusNumber();
		}
	}

	private void rateWinningWithBonusNumber() {
		if ((int)lotto.getNumbers().stream().filter(winningNumbersWithBonusNumber::contains).count()
			== LottoConstant.COUNT_OF_LOTTO_NUMBERS) {
			winningRating = WinningRating.SECOND;
		}
	}

	private void rateWinningWithoutBonusNumber() {
		for (WinningRating rating : WinningRating.values()) {
			if (rating.getCountOfMatchedNumber() == countOfMatchedNumber) {
				winningRating = rating;
			}
		}
	}

	private void init() {
		winningNumbers = winningAndBonusNumbers.getWinningNumbers();
		bonusNumber = winningAndBonusNumbers.getBonusNumber();
		winningNumbersWithBonusNumber = new ArrayList<>();
		winningNumbersWithBonusNumber.addAll(winningNumbers);
		winningNumbersWithBonusNumber.add(bonusNumber);
	}

	private void calculateCountOfMatchedNumber() {
		countOfMatchedNumber = (int)lotto.getNumbers()
			.stream()
			.filter(number -> winningNumbers.contains(number))
			.count();
	}
}
