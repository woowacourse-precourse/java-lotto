package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
	public static int readUserLottoPurchaseAmount() {
		String lottoPurchaseAmount = Console.readLine();

		return Integer.parseInt(lottoPurchaseAmount);
	}
}
