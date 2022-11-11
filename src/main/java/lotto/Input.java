package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static void enterMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String userInput = Console.readLine();
		Money.checkMoneyInput(userInput);
	}

	public static String enterWinningNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String userInput = Console.readLine();
		return userInput;
	}

	public static String enterBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		String userInput = Console.readLine();
		return userInput;
	}
}
