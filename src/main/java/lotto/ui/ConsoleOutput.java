package lotto.ui;

import lotto.Rule;
import lotto.Setup;

import java.util.List;

public class ConsoleOutput {
	private static final String ERROR_MESSAGE = "[ERROR]";
	private static final String SPACE = " ";
	private static final String EXIT_MESSAGE = "프로그램을 종료합니다";

	public static final String REQUEST_TOTAL_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String REQUEST_LOTTO_NUMBER = "\n당첨 번호를 입력해 주세요.";
	public static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

	public static final String EMPTY = "입력하지 않으셨습니다.";
	public static final String AMOUNT_NOT_A_NUMBER = "구입금액은 숫자만 입력이 가능합니다.";
	public static final String AMOUNT_LESS_THAN_1000 = "구입금액은 1000원 이상부터 가능합니다.";
	public static final String AMOUNT_NOT_ASSIGNED_CURRENCY_UNIT = String.format("구입금액은 %d원 단위로 입력이 가능합니다.", Setup.LOTTO_PRICE.getValue());

	public static final String LOTTO_NUMBER_NOT_CORRECTLY_FORMATTED = "로또 번호는 1,2,3,4,5,6 형식으로 입력해야 합니다.";
	public static final String LOTTO_NUMBER_NOT_CORRECTLY_COUNTED = "로또 번호는 6개의 숫자를 입력해야 합니다.";
	public static final String LOTTO_NUMBER_NOT_IN_BETWEEN_1_45 = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String LOTTO_NUMBER_DUPLICATED = "로또 번호는 중복이 없어야 합니다.";

	public static final String BONUS_NUMBER_NOT_IN_BETWEEN_1_45 = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
	public static final String BONUS_NUMBER_NOT_CORRECTLY_COUNTED = "보너스 번호는 1개의 숫자를 입력해야 합니다.";
	public static final String BONUS_NUMBER_DUPLICATED = "보너스 번호는 로또 번호와 중복이 없어야 합니다.";

	public static final String PURCHASED_LOTTO_NUMBERS = "\n%d개를 구매했습니다.\n";

	public static final String RESULT_TITLE = "\n당첨 통계";
	public static final String LINE = "---";
	public static final String RESULT_CONTENT = "%d개 일치 (%s) - %d개\n";
	public static final String RESULT_CONTENT_BONUS = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";
	public static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";


	public static void PrintErrorMessage(String message) {
		System.out.println(ERROR_MESSAGE + SPACE + message);
		throw new IllegalArgumentException();
	}

	public static void PrintExitMessage() {
		System.out.println(EXIT_MESSAGE);
	}

	public static void PrintRequestMessage(String message) {
		System.out.println(message);
	}

	public static void PrintNotificationMessage(int purchasedLotto) {
		System.out.printf(PURCHASED_LOTTO_NUMBERS,purchasedLotto);
	}

	public static void PrintIssuedLotto(List<Integer> numbers) {
		System.out.println(numbers);
	}

	public static void PrintResultMessage(int specialMatch, int[] counting) {
		System.out.println(RESULT_TITLE);
		System.out.println(LINE);
		System.out.printf(RESULT_CONTENT, Rule.FIFTH_PRIZE.getMatches(),Rule.FIFTH_PRIZE.getReward(), counting[0]);
		System.out.printf(RESULT_CONTENT, Rule.FOURTH_PRIZE.getMatches(),Rule.FOURTH_PRIZE.getReward(), counting[1]);
		System.out.printf(RESULT_CONTENT, Rule.THIRD_PRIZE.getMatches(),Rule.THIRD_PRIZE.getReward(), counting[2]);
		System.out.printf(RESULT_CONTENT_BONUS, Rule.SECOND_PRIZE.getMatches(),Rule.SECOND_PRIZE.getReward(), specialMatch);
		System.out.printf(RESULT_CONTENT, Rule.FIRST_PRIZE.getMatches(),Rule.FIRST_PRIZE.getReward(), counting[3]);
	}
	public static void PrintProfitMessage(String profit) {
		System.out.printf(PROFIT_MESSAGE,profit);
	}


}
