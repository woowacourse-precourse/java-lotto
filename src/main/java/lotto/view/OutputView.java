package lotto.view;

import java.util.List;

import lotto.domain.Lotto;

public class OutputView {
	private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
	private static final String PRINT_LOTTO_QUANTITY = "\n%d개를 구매했습니다.\n";

	public static void printAmountMessage() {
		System.out.println(INPUT_AMOUNT_MESSAGE);
	}

	public static void printWinningNumberMessage() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
	}

	public static void printAllLottoNumber(List<Lotto> lottos) {
		System.out.printf(PRINT_LOTTO_QUANTITY, lottos.size());
		lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}
}
