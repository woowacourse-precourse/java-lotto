package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.MainView;

public class InputHandler {

	public static String inputPurchaseQuantity() {
		MainView.INPUT_PURCHASE_QUANTITY();
		return Console.readLine();
	}

	public static String inputLottoWinningNumber() {
		MainView.INPUT_WINNING_NUMBER();
		return Console.readLine();
	}

	public static String inputLottoWinningBonusNumber() {
		MainView.INPUT_WINNING_BONUS_NUMBER();
		return Console.readLine();
	}

}
