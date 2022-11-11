package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputExceptionHandler;

public class InputView {
	public static String inputAmount() {
		OutputView.printAmountMessage();
		return InputExceptionHandler.checkPurchaseAmountForm(Console.readLine());
	}

	public static String inputWinningNumber() {
		OutputView.printWinningNumberMessage();
		return InputExceptionHandler.checkWinningNumberForm(Console.readLine());
	}

	public static String inputBonusNumber() {
		OutputView.printBonusNumberMessage();
		return Console.readLine();
	}
}
