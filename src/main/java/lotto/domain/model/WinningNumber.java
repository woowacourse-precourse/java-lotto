package lotto.domain.model;

import lotto.domain.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.Constants.*;

public class WinningNumber {
	private final List<Integer> winningNumbers;

	public WinningNumber(String winningNumbers) {
		validateLastCharacter(winningNumbers);
		this.winningNumbers = initWinningNumbers(winningNumbers);
		validateCount(this.winningNumbers);
		validateRange(this.winningNumbers);
		validateOverlap(this.winningNumbers);
	}

	private void validateLastCharacter(String winningNumbers) {
		try {
			if (winningNumbers.charAt(winningNumbers.length() - 1) == SPLIT) {
				new ExceptionHandler(ErrorMessage.ERROR_WRONG_INPUT).tryCatch(ErrorMessage.ERROR_WRONG_INPUT);
			}
		} catch (StringIndexOutOfBoundsException exception) {
			new ExceptionHandler(ErrorMessage.ERROR_WRONG_INPUT).tryCatch(ErrorMessage.ERROR_WRONG_INPUT);
		}

	}

	private void validateOverlap(List<Integer> winningNumbers) {
		HashSet<Integer> numberSet = new HashSet<>(winningNumbers);

		if (numberSet.size() != winningNumbers.size()) {
			new ExceptionHandler(ErrorMessage.ERROR_OVERLAP).tryCatch(ErrorMessage.ERROR_OVERLAP);
		}
	}

	private List<Integer> initWinningNumbers(String input) {
		String[] numbers = input.split(Character.toString(SPLIT));
		List<Integer> winningNumber = new ArrayList<>();
		for (String number : numbers) {
			winningNumber.add(validateInt(number));
		}
		return winningNumber;
	}

	private int validateInt(String input) {
		int number = 0;

		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException exception) {
			new ExceptionHandler(ErrorMessage.ERROR_NOT_INTEGER).tryCatch(ErrorMessage.ERROR_NOT_INTEGER);
		}
		return number;
	}

	private void validateCount(List<Integer> winning_numbers) {
		if (winning_numbers.size() != SIZE) {
			new ExceptionHandler(ErrorMessage.ERROR_WRONG_SIZE).tryCatch(ErrorMessage.ERROR_WRONG_SIZE);
		}
	}

	private void validateRange(List<Integer> winning_numbers) {
		for (int number : winning_numbers) {
			if (number < LOTTO_MIN || LOTTO_MAX < number) {
					new ExceptionHandler(ErrorMessage.ERROR_WRONG_RANGE).tryCatch(ErrorMessage.ERROR_WRONG_RANGE);
			}
		}
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}
}
