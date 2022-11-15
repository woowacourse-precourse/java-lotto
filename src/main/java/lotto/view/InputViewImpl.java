package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

	public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

	public String getMoney() {
		System.out.println(INPUT_MONEY_MESSAGE);
		String input = readInput();
		System.out.println();
		return input;
	}

	@Override
	public String getWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
		String input = readInput();
		System.out.println();
		return input;
	}

	@Override
	public String getBonus() {
		System.out.println(INPUT_BONUS_MESSAGE);
		String input = readInput();
		System.out.println();
		return input;
	}

	protected String readInput() {
		return Console.readLine();
	}
}
