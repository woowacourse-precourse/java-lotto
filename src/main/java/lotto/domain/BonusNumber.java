package lotto.domain;


import static lotto.domain.Constants.MAX_NUMBER;
import static lotto.domain.Constants.MIN_NUMBER;

public class BonusNumber {
	private final int number;

	public BonusNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException();
		}
	}
}
