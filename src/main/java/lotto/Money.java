package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {

	public static final String NUMBER_SERIES = "[0-9]+";

	public Money() {
	}

	public static void inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String userInput = Console.readLine();
		checkMoneyInput(userInput);
	}

	public static void checkMoneyInput(String input) {
		if (!input.matches(NUMBER_SERIES)) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}

		if (!isUnitOfThousand(input)) {
			throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
		}
	}

	private static boolean isUnitOfThousand (String input) {
		return Integer.parseInt(input) % 1000 == 0;
	}
}
