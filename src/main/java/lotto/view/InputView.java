package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String inputAmount() {
		OutputView.printAmountMessage();
		return Console.readLine();
	}

	public static String inputWinningNumber() {
		OutputView.printWinningNumberMessage();
		return Console.readLine();
	}

	public static String inputBonusNumber() {
		OutputView.printBonusNumberMessage();
		return Console.readLine();
	}
}
