package lotto.utils;

public class InputValidationUtils {

	private static final String ERR_MESSAGE_HEAD
		= "[ERROR] ";

	public static void validatePrice(final int price) {
		if (!isDivisibleWithThousand(price)) {
			throw new IllegalArgumentException(
				ERR_MESSAGE_HEAD + "구입 금액은 1,000원으로 나누어 떨어지는 수여야 합니다."
			);
		}
	}

	private static boolean isDivisibleWithThousand(final int price) {
		return price != 0 && price % 1000 == 0;
	}
}
