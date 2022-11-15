package lotto.util;

import static lotto.util.Constants.*;

public class ErrorMessage {

	private static final String PREFIX = "[ERROR]";
	private static final String INVALID_LOTTO_NUMBER = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	private static final String INVALID_NUMBER = "숫자가 아닙니다.";
	private static final String NOT_UNITS_OF_1000 = "1,000원 단위의 금액이여야 합니다.";
	private static final String INVALID_NUMBER_OF_LOTTO_NUMBERS = "로또 번호는 6개여야 합니다.";
	private static final String DUPLICATED_LOTTO_NUMBER = "로또 번호는 서로 다른 숫자여야 합니다.";

	public static String isDuplicatedLottoNumber() {
		return generate(DUPLICATED_LOTTO_NUMBER);
	}

	public static String isNotUnitsOf1000() {
		return generate(NOT_UNITS_OF_1000);
	}

	public static String isInvalidNumberOfLottoNumbers() {
		return generate(INVALID_NUMBER_OF_LOTTO_NUMBERS);
	}

	public static String isInvalidNumber() {
		return generate(INVALID_NUMBER);
	}

	public static String isInvalidLottoNumber() {
		return generate(INVALID_LOTTO_NUMBER);
	}

	private static String generate(String message) {
		return PREFIX + EMPTY + message;
	}

}
