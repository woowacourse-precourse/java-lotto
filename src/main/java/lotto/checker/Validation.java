package lotto.checker;

import java.util.Arrays;
import java.util.List;

import lotto.domain.WinningLotto;
import lotto.exception.Exception;

public class Validation {
	private static final int MAX_PRICE = 100000; //1인당 최대 복권 구매금액은 10만원이다.
	private static final int MIN_PRICE = 1000;
	private static final int MAX_WINNING_NUMBER_LENGTH = 6;
	private static final int MAX_BONUS_NUMBER_LENGTH = 1;
	private static final int MAX_NUMBER = 45;
	private static final int MIN_NUMBER = 1;
	private static final int ZERO = 0;

	public static void validatePriceException(String userInput) {
		validateNumberOnlyException(Arrays.asList(userInput));
		validatePriceRangeException(userInput);
	}

	private static void validatePriceRangeException(String userInput) {

		if (isMaxPriceException(userInput)) {
			throw Exception.MAX_PRICE_EXCEPTION.getException();
		}

		if (isMinPriceException(userInput)) {
			throw Exception.MIN_PRICE_EXCEPTION.getException();
		}

		if (isPriceRangeException(userInput)) {
			throw Exception.PRICE_RANGE_EXCEPTION.getException();
		}

	}

	private static boolean isPriceRangeException(String userInput) {
		return (Integer.parseInt(userInput) % MIN_PRICE) > ZERO;
	}

	private static boolean isMinPriceException(String userInput) {
		return Integer.parseInt(userInput) < MIN_PRICE;
	}

	private static boolean isMaxPriceException(String userInput) {
		return Integer.parseInt(userInput) > MAX_PRICE;
	}

	public static void validateWinningNumberInput(List<String> winningNumber) {
		validateNumberOnlyException(winningNumber);
		validateLengthException(winningNumber, MAX_WINNING_NUMBER_LENGTH);
		validateSameNumberException(winningNumber);
		validateNumberRangeException(winningNumber);
	}

	public static void validateBonusNumberInput(List<String> bonusNumber) {
		validateNumberOnlyException(bonusNumber);
		validateLengthException(bonusNumber, MAX_BONUS_NUMBER_LENGTH);
		validateSameNumberInWinningNumberException(bonusNumber);
		validateNumberRangeException(bonusNumber);
	}

	public static void validateSameNumberInWinningNumberException(List<String> bonusNumber) {
		if (WinningLotto.getWinningNumber().contains(bonusNumber.get(0))) {
			throw Exception.SAME_NUMBER_EXCEPTION.getException();
		}
	}

	public static void validateNumberRangeException(List<String> numbers) {
		for (String number : numbers) {
			if (isMaxNumberException(number) || isMinNumberException(number)) {
				throw Exception.NUMBER_RANGE_EXCEPTION.getException();
			}
		}
	}

	private static boolean isMinNumberException(String number) {
		return Integer.parseInt(number) < MIN_NUMBER;
	}

	private static boolean isMaxNumberException(String number) {
		return Integer.parseInt(number) > MAX_NUMBER;
	}

	public static boolean isSameNumber(List<String> winningNumber) {
		boolean isSameNumberExist = winningNumber.stream()
			.distinct()
			.count() != winningNumber.size();

		return isSameNumberExist;
	}

	public static void validateSameNumberException(List<String> winningNumber) {

		if (isSameNumber(winningNumber)) {
			throw Exception.SAME_NUMBER_EXCEPTION.getException();
		}

	}

	public static void validateLengthException(List<String> numbers, int maxLength) {
		if (numbers.size() > maxLength) {
			throw Exception.NUMBER_ONLY_EXCEPTION.getException();
		}
	}

	public static void validateNumberOnlyException(List<String> numbers) {
		try {
			for (String number : numbers) {
				Integer.parseInt(number);
			}
		} catch (IllegalArgumentException e) {
			throw Exception.NUMBER_ONLY_EXCEPTION.getException();
		}
	}
}
