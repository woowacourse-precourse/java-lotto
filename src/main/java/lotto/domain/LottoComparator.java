package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import lotto.constant.WinningRating;

public class LottoComparator {
	private static final int INITIAL_VALUE = 0;
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

	public void compare(Lotto lotto) {
		this.lotto = lotto;

		init();
		calculateCountOfMatchedNumber(lotto.getNumbers());
		rateWinning();
	}

	private void rateWinning() {
		if (countOfMatchedNumber >= WinningRating.FIFTH.getCountOfMatchedNumber()
			&& countOfMatchedNumber != WinningRating.SECOND.getCountOfMatchedNumber()) {
			rateNotSecondAndThirdWinning();
		}
		if (countOfMatchedNumber == WinningRating.SECOND.getCountOfMatchedNumber()) {
			rateSecondOrThirdWinning();
		}
	}

	private void rateSecondOrThirdWinning() {
		winningRating = WinningRating.THIRD;
		if (new HashSet<>(winningNumbersWithBonusNumber).containsAll(lotto.getNumbers())) {
			winningRating = WinningRating.SECOND;
		}
	}

	private void rateNotSecondAndThirdWinning() {
		Arrays.stream(WinningRating.values())
			.filter(rating -> rating != WinningRating.SECOND)
			.collect(Collectors.toList())
			.forEach(rating -> {
				if (rating.getCountOfMatchedNumber() == countOfMatchedNumber)
					winningRating = rating;
			});
	}

	private void init() {
		winningRating = WinningRating.MISS;
		countOfMatchedNumber = INITIAL_VALUE;
		winningNumbers = winningAndBonusNumbers.getWinningNumbers();
		bonusNumber = winningAndBonusNumbers.getBonusNumber();
		winningNumbersWithBonusNumber = new ArrayList<>();
		winningNumbersWithBonusNumber.addAll(winningNumbers);
		winningNumbersWithBonusNumber.add(bonusNumber);
	}

	private void calculateCountOfMatchedNumber(List<Integer> numbers) {
		countOfMatchedNumber = (int)numbers.stream().filter(winningNumbers::contains).count();
	}

	public WinningRating getWinningRating() {
		return winningRating;
	}
}