package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.MainView;

public class InputHandler {

	public static String inputPurchaseQuantity() {
		MainView.inputPurchaseQuantity();
		return Console.readLine();
	}

	public static String inputLottoWinningNumber() {
		MainView.inputWinningNumber();
		return Console.readLine();
	}

	public static String inputLottoWinningBonusNumber() {
		MainView.inputWinningBonusNumber();
		return Console.readLine();
	}

}
