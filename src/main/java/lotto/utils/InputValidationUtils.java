package lotto.utils;

public class InputValidationUtils {

	private static final String ERR_MESSAGE_HEAD = "[ERROR] ";

	public static void validateNumbers(final String[] splitNumbers) {
		for (String splitNumber : splitNumbers) {
			validateFormat(splitNumber);
		}
	}

	public static void validateFormat(final String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(
				ERR_MESSAGE_HEAD + "잘못된 형식의 입력입니다."
			);
		}
	}
}
