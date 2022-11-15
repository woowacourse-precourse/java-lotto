package lotto.domain;

import lotto.util.Validator;

public class BonusNumber {
	private final int bonusNumber;

	public BonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
		validateBonusNumber(bonusNumber, winningNumbers);
		this.bonusNumber = bonusNumber;
	}

	private void validateBonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
		Validator.validateNumberRange(bonusNumber);
		Validator.validateExclusion(bonusNumber, winningNumbers.getWinningNumbers());
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
