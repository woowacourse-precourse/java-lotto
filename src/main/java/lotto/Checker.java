package lotto;

import java.util.Arrays;
import java.util.List;

import lotto.domain.WinningLotto;

public class Checker {
	private static final int MAX_PRICE = 100000; //1인당 최대 복권 구매금액은 10만원이다.
	private static final int MAX_WINNING_NUMBER_LENGTH = 6;
	private static final int MAX_BONUS_NUMBER_LENGTH = 1;
	private static final int MAX_NUMBER = 45;
	private static final int MIN_NUMBER = 1;

	public static void checkPriceInput(String userInput) {
		checkNumberOnlyException(Arrays.asList(userInput));
		checkMaxPrice(userInput);
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
			if (Integer.parseInt(number) > MAX_NUMBER || Integer.parseInt(number) < MIN_NUMBER) {
				Exception.numberRangeException();
			}
		}
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

	public static void checkMaxPrice(String userInput) {
		if (isExceedMaxPrice(userInput)) {
			Exception.maxPriceException();
		}
	}

	public static boolean isExceedMaxPrice(String userInput) {
		return Integer.parseInt(userInput) > MAX_PRICE;
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
