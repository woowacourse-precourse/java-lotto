package lotto.ui;

import lotto.Setup;

public class ConsoleOutput {
	private static final String ERROR_SYMBOL = "[ERROR]";
	private static final String SPACE = " ";

	public static final String REQUEST_TOTAL_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String REQUEST_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
	public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

	public static final String EMPTY = "입력하지 않으셨습니다. 프로그램을 종료합니다.";
	public static final String AMOUNT_NOT_A_NUMBER = "구입금액은 숫자만 입력이 가능합니다. 프로그램을 종료합니다.";
	public static final String AMOUNT_LESS_THAN_1000 = "구입금액은 1000원 이상부터 가능합니다. 프로그램을 종료합니다.";
	public static final String AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT = String.format("구입금액은 %d원 단위로 입력이 가능합니다. 프로그램을 종료합니다.", Setup.LOTTO_PRICE.getValue());

	public static final String NUMBER_NOT_CORRECTLY_FORMATTED = "로또 번호는 1,2,3,4,5,6 형식으로 입력해야 합니다. 프로그램을 종료합니다.";
	public static final String NUMBER_NOT_CORRECTLY_COUNTED = "로또 번호는 6개의 숫자를 입력해야 합니다. 프로그램을 종료합니다.";
	public static final String NUMBER_NOT_IN_BETWEEN_1_45 = "로또 번호는 1부터 45 사이의 숫자여야 합니다. 프로그램을 종료합니다.";
	public static final String NUMBER_DETECTED_DUPLICATE = "로또 번호는 중복이 없어야 합니다. 프로그램을 종료합니다.";


	public static void PrintErrorMessage(String message) {
		System.out.println(ERROR_SYMBOL + SPACE + message);
		throw new IllegalArgumentException();
	}

	public static void PrintRequestMessage(String message) {
		System.out.println(message);
	}
}
