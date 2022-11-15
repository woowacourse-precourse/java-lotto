package lotto.util;

import static lotto.util.Constants.*;

import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import lotto.service.WinningNumber;

public class Validator {
	public static void validateNumber(String input) {
		if (!input.matches(ONLY_INTEGER_SERIES)) {
			throw new IllegalArgumentException(ERROR_NUMERIC);
		}
	}

	public static void validateNoZero(String input) {
		if (Integer.parseInt(input) == ZERO) {
			throw new IllegalArgumentException(ERROR_ZERO);
		}
	}

	public static void validateMaxNumber(String input) {
		if (Integer.parseInt(input) > MAX_NUMBER) {
			throw new IllegalArgumentException(ERROR_MAX_NUMBER);
		}
	}

	public static void validateDuplicateBonusNumber(String input, Set<Integer> winningNumber) {
		if (winningNumber.contains(Integer.parseInt(input))) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_WITH_WINNINGNUM);
		}
	}

	public static void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);
		}
	}

	public static void validateDuplicate(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != numbers.size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATE);
		}
	}

	public static void validateUnitOfMoney(String input) {
		if (!isUnitOfThousand(input)) {
			throw new IllegalArgumentException(ERROR_UNIT_OF_THOUSAND);
		}
	}

	private static boolean isUnitOfThousand(String input) {
		return Integer.parseInt(input) % LOTTO_PRICE == 0;
	}

	public static void validateDuplicate(String winningNumber) {
		if (hasDuplicatedNum(WinningNumber.convertToSet(winningNumber))) {
			throw new IllegalArgumentException(ERROR_DUPLICATE);
		}
	}

	private static boolean hasDuplicatedNum(Set<Integer> numbers) {
		return numbers.size() != LOTTO_NUMBER_SIZE;
	}

	public static void validateInputWinningNumber(StringTokenizer splitter) {
		if (splitter.countTokens() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException(ERROR_NOT_COMMA);
		}
	}
}
