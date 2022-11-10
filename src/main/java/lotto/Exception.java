package lotto;

public class Exception {
	private static String ERROR = "[ERROR] ";
	private static String NUMBER_ONLY_EXCEPTION_MESSAGE = ERROR + "숫자만 입력가능합니다.";
	private static String MAX_PRICE_EXCEPTION_MESSAGE = ERROR + "1인 구매 가능 금액은 10만원입니다.";

	public static void numberOnlyException() {
		throw new IllegalArgumentException(NUMBER_ONLY_EXCEPTION_MESSAGE);
	}

	public static void maxPriceException() {
		throw new IllegalArgumentException(MAX_PRICE_EXCEPTION_MESSAGE);
	}
}
