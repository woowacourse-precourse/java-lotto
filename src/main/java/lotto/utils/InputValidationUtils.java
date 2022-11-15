package lotto.utils;

public class InputValidationUtils {

	private static final String ERR_MESSAGE_HEAD
		= "[ERROR] ";

	private static final int MAX_NUMBER = 45;

	private static final int MIN_NUMBER = 1;

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

	public static void validateNumber(final int number) {
		if (isOutOfBound(number)) {
			throw new IllegalArgumentException(
				ERR_MESSAGE_HEAD + "로또 번호는 1부터 45 사이의 숫자여야 합니다."
			);
		}
	}

	private static boolean isOutOfBound(final int number) {
		return number > MAX_NUMBER || number < MIN_NUMBER;
	}
}
