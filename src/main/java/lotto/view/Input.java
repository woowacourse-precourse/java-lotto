package lotto.view;

import static lotto.util.Constants.*;

import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.BonusNumber;
import lotto.service.Money;
import lotto.service.WinningNumber;

public class Input {
	public static int enterMoney() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
		String userInput = Console.readLine();
		Money.checkMoneyInput(userInput);
		return Money.calculateMaximumLottoCount(userInput);
	}

	public static Set<Integer> enterWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER);
		String userInput = Console.readLine();
		WinningNumber.checkWinningNumber(userInput);
		return WinningNumber.convertToSet(userInput);
	}

	public static int enterBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		String userInput = Console.readLine();
		BonusNumber.checkBonusNumber(userInput, WinningNumber.getWinningNumber());
		return Integer.parseInt(userInput);
	}
}
