package lotto.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lotto.constant.ErrorLog;
import lotto.constant.LottoConstant;

public class Validator {
	public static void validateNumberRange(List<Integer> numbers) {
		if (numbers.stream().anyMatch(number -> number < LottoConstant.MINIMUM_LOTTO_NUMBER || number > LottoConstant.MAXIMUM_LOTTO_NUMBER)) {
			throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자만 가능합니다.");
		}
	}
	public static void validateNoDuplication(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 숫자 간에 중복이 있으면 안 됩니다.");
		}
	}
	public static void validateDivisibility(int amount) {
		if (amount % LottoConstant.PRICE_OF_LOTTO != 0) {
			throw new IllegalArgumentException(ErrorLog.INDIVISIBLE_PURCHASING_AMOUNT_ERROR.log());
		}
	}
	public static void validateIntegerOrNot(String input) {
		if (input.chars().anyMatch(letter -> letter < '0' || letter > '9')) {
			throw new IllegalArgumentException(ErrorLog.NOT_INTEGER_INPUT_ERROR.log());
		}
	}

	public static void validateFormOfWinningNumbers(String winningNumbers) {
		Pattern pattern = Pattern.compile("^[1-45]+,[1-45]+,[1-45]+,[1-45]+,[1-45]+,[1-45]+$");
		Matcher matcher = pattern.matcher(winningNumbers);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호의 형식이 올바르지 않습니다. 올바른 예) 1,2,3,4,5,6");
		}
	}
}
