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
		if (numbers.size() != LottoConstant.COUNT_OF_LOTTO_NUMBERS) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateNoDuplication(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != LottoConstant.COUNT_OF_LOTTO_NUMBERS) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateDivisibility(int amount) {
		if (amount % LottoConstant.PRICE_OF_LOTTO != LottoConstant.ZERO) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateIntegerOrNot(String input) {
		if (input.chars().anyMatch(letter -> letter < LottoConstant.MINIMUM_DIGIT || letter > LottoConstant.MAXIMUM_DIGIT)) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateFormOfWinningNumbers(String winningNumbers) {
		Pattern pattern = Pattern.compile(LottoConstant.FORM_OF_WINNING_NUMBERS);
		Matcher matcher = pattern.matcher(winningNumbers);
		if (!matcher.matches()) {
			throw new IllegalArgumentException();
		}
	}
}
