package lotto.domain.model;

import lotto.domain.ErrorMessage;

import java.util.List;

public class BonusBall {
	private final int bonusBall;

	public BonusBall(String number, List<Integer> winningNumber) {
		bonusBall = validateInt(number);
		validateRange(winningNumber);
	}

	private void validateRange(List<Integer> winningNumbers) {
		if (bonusBall < 1 || 45 < bonusBall) {
			new ExceptionHandler(ErrorMessage.ERROR_WRONG_RANGE).tryCatch(ErrorMessage.ERROR_WRONG_RANGE);
		}
		if (winningNumbers.contains(bonusBall)){
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
