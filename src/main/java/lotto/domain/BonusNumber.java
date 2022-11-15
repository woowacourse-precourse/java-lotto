package lotto.domain;

import lotto.util.Validator;

public class BonusNumber {
	private final WinningNumbers winningNumbers;
	private final int bonusNumber;

	public BonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
		this.winningNumbers = winningNumbers;
		validateBonusNumber(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	private void validateBonusNumber(int bonusNumber) {
		Validator.validateNumberRange(bonusNumber);
		Validator.validateExclusion(bonusNumber, winningNumbers.getWinningNumbers());
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
