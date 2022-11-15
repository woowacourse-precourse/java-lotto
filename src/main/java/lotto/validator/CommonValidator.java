package lotto.validator;

public class CommonValidator {
	public static void validateIsNumber(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_NOT_NUMBER);
		}
	}
}
