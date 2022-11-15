package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Integer> winningNumbersWithBonusNumber = new ArrayList<>();

		addBonusNumberToWinningNumbers(winningNumbersWithBonusNumber);
		int countOfMatchedNumber = calculateCountOfMatchedNumber(lotto.getNumbers());
		rateWinning(lotto, winningNumbersWithBonusNumber, countOfMatchedNumber);
	}

	private void addBonusNumberToWinningNumbers(List<Integer> winningNumbersWithBonusNumber) {
		winningNumbersWithBonusNumber.addAll(winningNumbers.getWinningNumbers());
		winningNumbersWithBonusNumber.add(bonusNumber.getBonusNumber());
	}

	private int calculateCountOfMatchedNumber(List<Integer> numbers) {
		return (int)numbers.stream().filter(winningNumbers.getWinningNumbers()::contains).count();
	}

	private void rateWinning(Lotto lotto, List<Integer> winningNumbersWithBonusNumber, int countOfMatchedNumber) {
		if (countOfMatchedNumber >= WinningRating.FIFTH.getCountOfMatchedNumber()
			&& countOfMatchedNumber != WinningRating.SECOND.getCountOfMatchedNumber()) {
			rateNotSecondAndThirdWinning(countOfMatchedNumber);
		}
		if (countOfMatchedNumber == WinningRating.SECOND.getCountOfMatchedNumber()) {
			rateSecondOrThirdWinning(lotto, winningNumbersWithBonusNumber);
		}
	}

	private void rateSecondOrThirdWinning(Lotto lotto, List<Integer> winningNumbersWithBonusNumber) {
		winningRating = WinningRating.THIRD;
		if (new HashSet<>(winningNumbersWithBonusNumber).containsAll(lotto.getNumbers())) {
			winningRating = WinningRating.SECOND;
		}
	}

	private void rateNotSecondAndThirdWinning(int countOfMatchedNumber) {
		Arrays.stream(WinningRating.values())
			.filter(rating -> rating != WinningRating.SECOND)
			.collect(Collectors.toList())
			.forEach(rating -> {
				if (rating.getCountOfMatchedNumber() == countOfMatchedNumber)
					winningRating = rating;
			});
	}

	public WinningRating getWinningRating() {
		return winningRating;
	}
}