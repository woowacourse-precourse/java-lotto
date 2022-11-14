package lotto.domain.player;

import lotto.domain.util.Validator;

public class BonusNumber {
	private final String bonusNumber;

	public BonusNumber(String bonusNumberInput, WinningNumber winningNumber) {
		Validator.validateBonusNumber(bonusNumberInput, winningNumber.toNumbers());
		this.bonusNumber = bonusNumberInput;
	}

	public static BonusNumber from(String bonusNumberInput, WinningNumber winningNumber) {
		return new BonusNumber(bonusNumberInput, winningNumber);
	}

	public int toNumber() {
		return Integer.parseInt(bonusNumber);
	}
}
