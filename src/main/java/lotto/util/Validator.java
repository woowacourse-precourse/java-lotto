package lotto.util;

import lotto.constant.ErrorLog;
import lotto.constant.LottoConstant;

public class Validator {
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
}
