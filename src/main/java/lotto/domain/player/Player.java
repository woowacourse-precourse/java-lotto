package lotto.domain.player;

import lotto.ui.ConsoleInput;

import static lotto.ui.ConsoleOutput.*;

public class Player {

	public String receivePurchaseAmount() {
		PrintRequestMessage(REQUEST_TOTAL_AMOUNT);
		return ConsoleInput.readLine();
	}

	public String receiveWinningNumber() {
		PrintRequestMessage(REQUEST_WINNING_NUMBER);
		return ConsoleInput.readLine();
	}

	public String receiveBonusNumber() {
		PrintRequestMessage(REQUEST_BONUS_NUMBER);
		return ConsoleInput.readLine();
	}
}
