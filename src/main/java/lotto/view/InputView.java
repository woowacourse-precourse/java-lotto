package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String BUY_SENTENCE = "구입금액을 입력해 주세요.";

	public static int inputMoney() {
		System.out.println(BUY_SENTENCE);
		String money = Console.readLine();
		validateInteger(money);
		return Integer.parseInt(money);
	}

	private static void validateInteger(String string) {
		if (!string.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("정수만 입력 가능합니다.");
		}
	}
}
