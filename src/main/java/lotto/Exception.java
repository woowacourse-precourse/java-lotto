package lotto;

public class Exception {
	private static String ERROR = "[ERROR] ";
	private static String NUMBER_ONLY_EXCEPTION_MESSAGE = ERROR + "숫자만 입력가능합니다.";
	private static String MAX_PRICE_EXCEPTION_MESSAGE = ERROR + "1인 구매 가능 금액은 10만원입니다.";
	private static String LENGTH_EXCEPTION_MESSAGE = ERROR + "6자리의 숫자를 입력해주세요.";
	private static String SAME_NUMBER_EXCEPTION_MESSAGE = ERROR + "중복되는 수가 존재합니다.";
	private static String NUMBER_RANGE_EXCEPTION_MESSAGE = ERROR + "1~45까지의 숫자만 입력 가능합니다.";

	public static void numberOnlyException() {
		throw new IllegalArgumentException(NUMBER_ONLY_EXCEPTION_MESSAGE);
	}

	public static void numberLengthException() {
		throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
	}

	public static void maxPriceException() {
		throw new IllegalArgumentException(MAX_PRICE_EXCEPTION_MESSAGE);
	}

	public static void sameNumberException() {
		throw new IllegalArgumentException(SAME_NUMBER_EXCEPTION_MESSAGE);
	}

	public static void numberRangeException() {
		throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
	}
}
