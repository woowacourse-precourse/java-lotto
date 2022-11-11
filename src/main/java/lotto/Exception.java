package lotto;

public class Exception {
	private static final String ERROR = "[ERROR] ";
	private static final String NUMBER_ONLY_EXCEPTION_MESSAGE = ERROR + "숫자만 입력가능합니다.";
	private static final String MAX_PRICE_EXCEPTION_MESSAGE = ERROR + "1인 구매 가능 금액은 10만원입니다.";
	private static final String MIN_PRICE_EXCEPTION_MESSAGE = ERROR + "1000원 이상의 금액을 입력해주세요.";
	private static final String PRICE_RANGE_EXCEPTION_MESSAGE = ERROR+"1000원 단위의 금액을 입력해주세요";
	private static final String LENGTH_EXCEPTION_MESSAGE = ERROR + "6자리의 숫자를 입력해주세요.";
	private static final String SAME_NUMBER_EXCEPTION_MESSAGE = ERROR + "중복되는 수가 존재합니다.";
	private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = ERROR + "1~45까지의 숫자만 입력 가능합니다.";

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

	public static void minPriceException() {
		throw new IllegalArgumentException(MIN_PRICE_EXCEPTION_MESSAGE);
	}

	public static void priceRangeException() {
		throw new IllegalArgumentException(PRICE_RANGE_EXCEPTION_MESSAGE);
	}
}
