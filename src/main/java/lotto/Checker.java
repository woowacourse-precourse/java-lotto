package lotto;

import java.util.Arrays;
import java.util.List;

import lotto.domain.WinningLotto;

public class Checker {
	private static final int MAX_PRICE = 100000; //1인당 최대 복권 구매금액은 10만원이다.
	private static final int MIN_PRICE = 1000;
	private static final int MAX_WINNING_NUMBER_LENGTH = 6;
	private static final int MAX_BONUS_NUMBER_LENGTH = 1;
	private static final int MAX_NUMBER = 45;
	private static final int MIN_NUMBER = 1;
	private static final int ZERO = 0;

	public static void checkPriceException(String userInput) {
		checkNumberOnlyException(Arrays.asList(userInput));
		checkPriceRangeException(userInput);
	}

	private static void checkPriceRangeException(String userInput) {

		if (isMaxPriceException(userInput)) {
			Exception.maxPriceException();
		}

		if (isMinPriceException(userInput)) {
			Exception.minPriceException();
		}

		if (isPriceRangeException(userInput)) {
			Exception.priceRangeException();
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

	public static void checkWinningNumberInput(List<String> winningNumber) {
		checkNumberOnlyException(winningNumber);
		checkLengthException(winningNumber, MAX_WINNING_NUMBER_LENGTH);
		checkSameNumberException(winningNumber);
		checkNumberRangeException(winningNumber);
	}

	public static void checkBonusNumberInput(List<String> bonusNumber) {
		checkNumberOnlyException(bonusNumber);
		checkLengthException(bonusNumber, MAX_BONUS_NUMBER_LENGTH);
		checkSameNumberInWinningNumberException(bonusNumber);
		checkNumberRangeException(bonusNumber);
	}

	public static void checkSameNumberInWinningNumberException(List<String> bonusNumber) {
		if (WinningLotto.getWinningNumber().contains(bonusNumber.get(0))) {
			Exception.sameNumberException();
		}
	}

	public static void checkNumberRangeException(List<String> numbers) {
		for (String number : numbers) {
			if (isMaxNumberException(number) || isMinNumberException(number)) {
				Exception.numberRangeException();
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

	public static void checkSameNumberException(List<String> winningNumber) {

		if (isSameNumber(winningNumber)) {
			Exception.sameNumberException();
		}

	}

	public static void checkLengthException(List<String> numbers, int maxLength) {
		if (numbers.size() > maxLength) {
			Exception.numberLengthException();
		}
	}

	public static void checkNumberOnlyException(List<String> numbers) {
		try {
			for (String number : numbers) {
				Integer.parseInt(number);
			}
		} catch (IllegalArgumentException e) {
			Exception.numberOnlyException();
		}
	}
}
