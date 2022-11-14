package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public enum InputView {
	PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
	WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요.");

	private final String message;

	InputView(String message) {
		this.message = message;
	}

	public String scanInput() {
		System.out.println(message);
		return Console.readLine();
	}
}
