package lotto.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.constant.LottoConstant;

public class Validator {
	public static void validateExclusion(int number, List<Integer> numbers) {
		if (numbers.contains(number)) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateNumberRange(int number) {
		if (number < LottoConstant.MINIMUM_LOTTO_NUMBER || number > LottoConstant.MAXIMUM_LOTTO_NUMBER) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateSizeOfNumbers(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateNoDuplication(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != 6) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateDivisibility(int amount) {
		if (amount % LottoConstant.PRICE_OF_LOTTO != 0) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateIntegerOrNot(String input) {
		if (input.chars().anyMatch(letter -> letter < '0' || letter > '9')) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateFormOfWinningNumbers(String winningNumbers) {
		Pattern pattern = Pattern.compile("^\\d{0,2},\\d{0,2},\\d{0,2},\\d{0,2},\\d{0,2},\\d{0,2}$");
		Matcher matcher = pattern.matcher(winningNumbers);
		if (!matcher.matches()) {
			throw new IllegalArgumentException();
		}
	}
}
