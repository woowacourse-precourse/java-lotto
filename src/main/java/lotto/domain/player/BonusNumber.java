package lotto.domain.player;

import lotto.domain.util.Validator;

public class BonusNumber {
	Validator validator = new Validator();

	private final String bonusNumber;

	public BonusNumber(String bonusNumberInput, WinningNumber winningNumber) {    // todo : validation을 위해 winningNumber를 전달받는다. 이 방식이 맞는 것인지 고찰이 필요.
		validator.validateBonusNumber(bonusNumberInput, winningNumber.toNumbers());
		this.bonusNumber = bonusNumberInput;
	}

	public static BonusNumber from(String bonusNumberInput, WinningNumber winningNumber) {
		return new BonusNumber(bonusNumberInput, winningNumber);
	}

	public int toNumber() {
		return Integer.parseInt(bonusNumber);
	}
}
