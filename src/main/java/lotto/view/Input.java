package lotto.view;

import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.BonusNumber;
import lotto.service.Money;
import lotto.service.WinningNumber;

public class Input {
	public static int enterMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String userInput = Console.readLine();
		Money.checkMoneyInput(userInput);
		return Money.calculateMaximumLottoCount(userInput);
	}

	public static Set<Integer> enterWinningNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String userInput = Console.readLine();
		WinningNumber.checkWinningNumber(userInput);
		return WinningNumber.convertToSet(userInput);
	}

	public static int enterBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		String userInput = Console.readLine();
		BonusNumber.checkBonusNumber(userInput);
		return Integer.parseInt(userInput);
	}
}
