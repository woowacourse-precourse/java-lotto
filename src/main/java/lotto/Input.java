package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static void enterMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String userInput = Console.readLine();
		Money.checkMoneyInput(userInput);
	}
}
