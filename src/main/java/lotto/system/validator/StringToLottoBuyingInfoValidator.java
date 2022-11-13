package lotto.system.validator;

public class StringToLottoBuyingInfoValidator {
	public static final String NOT_NATURAL_NUMBER_MESSAGE = "자연수값만 입력해야 합니다.";

	public static void validate(String target) {
		isOnlyNaturalNumber(target);
	}

	private static void isOnlyNaturalNumber(String target) {
		if (!target.matches("^[\\d,]+$")) {
			throw new IllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
		}
	}
}
