package lotto.domain.model;

import lotto.domain.ErrorMessage;

import java.util.List;

import static lotto.domain.Constants.LOTTO_MAX;
import static lotto.domain.Constants.LOTTO_MIN;

public class BonusBall {
	private final int bonusBall;

	public BonusBall(String number, List<Integer> winningNumber) {
		bonusBall = validateInt(number);
		validateRange(winningNumber);
	}

	private void validateRange(List<Integer> winningNumbers) {
		if (bonusBall < LOTTO_MIN || LOTTO_MAX < bonusBall) {
			new ExceptionHandler(ErrorMessage.ERROR_WRONG_RANGE).tryCatch(ErrorMessage.ERROR_WRONG_RANGE);
		}
		if (winningNumbers.contains(bonusBall)) {
			new ExceptionHandler(ErrorMessage.ERROR_OVERLAP).tryCatch(ErrorMessage.ERROR_OVERLAP);
		}
	}

	private int validateInt(String input) {
		int number = 0;

		try {
			number = Integer.parseInt(input);
		} catch (IllegalArgumentException exception) {
			new ExceptionHandler(ErrorMessage.ERROR_NOT_INTEGER).tryCatch(ErrorMessage.ERROR_NOT_INTEGER);
		}
		return number;
	}

	public int getBonusBall() {
		return bonusBall;
	}
}
