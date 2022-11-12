package lotto.util;

import lotto.constant.LottoConstant;

public class Validator {
	public static void validateDivisibility(int amount) {
		if (amount % LottoConstant.PRICE_OF_LOTTO != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
		}
	}
	public static void validateIntegerOrNot(String input) {
		if (input.chars().anyMatch(letter -> letter < '0' || letter > '9')) {
			throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
		}
	}
}
