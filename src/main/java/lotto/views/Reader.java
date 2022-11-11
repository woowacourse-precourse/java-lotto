package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.SystemValidator;

public class Reader {
	public static int readUserLottoPurchaseAmount() {
		String lottoPurchaseAmount = Console.readLine();

		SystemValidator.validateUserPurchaseAmount(lottoPurchaseAmount);

		return Integer.parseInt(lottoPurchaseAmount);
	}
}
