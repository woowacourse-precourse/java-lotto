package lotto.domain;

import java.util.List;

import lotto.exception.InputExceptionHandler;

public class WinningLotto extends Lotto {
	private int bonusNumber;

	public WinningLotto(List<Integer> numbers) {
		super(numbers);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(String bonusNumber) {
		this.bonusNumber = InputExceptionHandler.checkBonusNumberForm(getNumbers(), bonusNumber);
	}
}
