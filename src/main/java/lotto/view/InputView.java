package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	private InputView() {
	}

	public static String scanPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
		return Console.readLine();
	}

	public static String scanWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
		return Console.readLine();
	}

	public static String scanBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		return Console.readLine();
	}
}
