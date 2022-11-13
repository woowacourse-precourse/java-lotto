package lotto;

import lotto.controller.GameController;
import lotto.ui.ConsoleOutput;

public class Application {
	public static void main(String[] args) {
		try {
			GameController gameController = new GameController();
			gameController.run();
		} catch (Exception e) {
			ConsoleOutput.PrintExitMessage();
		}
	}
}
