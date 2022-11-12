package lotto;

import lotto.domain.Game;
import lotto.ui.ConsoleOutput;

public class Application {
	public static void main(String[] args) {
		try {
			Game game = new Game();
			game.run();
		} catch (Exception e) {
			ConsoleOutput.PrintExitMessage();
		}
	}
}
