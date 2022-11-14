package lotto.domain.player;

import lotto.ui.ConsoleInput;

import static lotto.ui.ConsoleOutput.*;

public class Player {
	ConsoleInput consoleInput = new ConsoleInput();

	public String receivePurchaseAmount() {
		PrintRequestMessage(REQUEST_TOTAL_AMOUNT);
		return consoleInput.readLine();
	}

	public String receiveWinningNumber() {
		PrintRequestMessage(REQUEST_WINNING_NUMBER);
		return consoleInput.readLine();
	}

	public String receiveBonusNumber() {
		PrintRequestMessage(REQUEST_BONUS_NUMBER);
		return consoleInput.readLine();
	}
}
