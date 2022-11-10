package lotto.ui;

import lotto.Setup;

public class ConsoleOutput {
	private static final String ERROR_SYMBOL = "[ERROR]";
	private static final String SPACE = " ";

	private static final String REQUEST_TOTAL_AMOUNT = "구입금액을 입력해 주세요.";

	public static final String AMOUNT_EMPTY = "입력하지 않으셨습니다. 프로그램을 종료합니다.";
	public static final String AMOUNT_NOT_A_NUMBER = "구입금액은 숫자만 입력이 가능합니다. 프로그램을 종료합니다.";
	public static final String AMOUNT_LESS_THAN_1000 = "구입금액은 1000원 이상부터 가능합니다. 프로그램을 종료합니다.";
	public static final String AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT = String.format("구입금액은 %d원 단위로 입력이 가능합니다. 프로그램을 종료합니다.", Setup.LOTTO_PRICE.getValue());

	public static void PrintErrorMessage(String message) {
		System.out.println(ERROR_SYMBOL + SPACE + message);
		throw new IllegalArgumentException();
	}

	public static void PrintRequestMessage() {
		System.out.println(REQUEST_TOTAL_AMOUNT);
	}

}
