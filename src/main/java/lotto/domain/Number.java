package lotto.domain;

public abstract class Number {
	protected final String ALLOWED_NUMBER = "^[0-9]+$";
	private final String NOT_NUMBER = "[ERROR] 숫자만 입력해 주시기 바랍니다.";
	private final String INVALID_FIRST_DIGIT_ZERO = "[ERROR] 두자리 이상의 숫자중 첫째자리는 1이상으로 입력해 주시기 바랍니다.";
	private final String INVALID_NUMBER_BOUNDARY = "[ERROR] 1-45 사이의 숫자만 입력해 주시기 바랍니다.";
	private final char FIRST_DIGIT_ZERO = '0';
	private final int DOUBLE_DIGIT = 2;
	private final int MIN_NUMBER_BOUNDARY = 1;
	private final int MAX_NUMBER_BOUNDARY = 45;

	protected void validateInputLetter(String number) {
		if (!number.matches(ALLOWED_NUMBER)) {
			throw new IllegalArgumentException(NOT_NUMBER);
		}
	}

	protected void validateFirstNumberZero(String number) {
		if (number.length() >= DOUBLE_DIGIT && number.charAt(0) == FIRST_DIGIT_ZERO) {
			throw new IllegalArgumentException(INVALID_FIRST_DIGIT_ZERO);
		}
	}

	protected void validateNumberBoundary(String number) {
		int convertedNumber = Integer.parseInt(number);
		if (convertedNumber < MIN_NUMBER_BOUNDARY || convertedNumber > MAX_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARY);
		}
	}
}
