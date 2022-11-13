package lotto;

import static lotto.validator.LottoNumberValidator.validateHasNoDuplication;
import static lotto.validator.LottoNumberValidator.validateIsInLottoRange;

public class WinningNumbersIncludingBonus {
	private Lotto winningNumbers;
	private int bonusNumber;

	public WinningNumbersIncludingBonus(Lotto winningNumbers, int bonusNumber) {
		validateBonusNumber(winningNumbers, bonusNumber);
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public Lotto getWinningNumbers() {
		return this.winningNumbers;
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}

	private void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
		validateIsInLottoRange(bonusNumber);
		validateHasNoDuplication(winningNumbers.getNumbers(), bonusNumber);
	}
}
