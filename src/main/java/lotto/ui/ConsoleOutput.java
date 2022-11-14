package lotto.ui;

import java.util.List;

public class ConsoleOutput {
	private static final String ERROR_MESSAGE = "[ERROR]";
	private static final String SPACE = " ";
	private static final String EXIT_MESSAGE = "프로그램을 종료합니다";

	public static final String REQUEST_TOTAL_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String REQUEST_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
	public static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

	public static final String PURCHASED_LOTTO_NUMBERS = "\n%d개를 구매했습니다.\n";

	public static final String RESULT_TITLE = "\n당첨 통계";
	public static final String LINE = "---";

	public static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";

	public static void PrintErrorMessage(String message) {
		System.out.println(ERROR_MESSAGE + SPACE + message);
	}

	public static void PrintExitMessage() {
		System.out.println(EXIT_MESSAGE);
	}

	public static void PrintRequestMessage(String message) {
		System.out.println(message);
	}

	public static void PrintNotificationMessage(int purchasedLotto) {
		System.out.printf(PURCHASED_LOTTO_NUMBERS, purchasedLotto);
	}

	public static void PrintIssuedLotto(List<Integer> numbers) {
		System.out.println(numbers);
	}

	public static void PrintResultMessage(String content) {
		System.out.println(RESULT_TITLE);
		System.out.println(LINE);
		System.out.println(content);
	}

	public static void PrintProfitMessage(String profit) {
		System.out.printf(PROFIT_MESSAGE, profit);
	}
}
