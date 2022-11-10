package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import static lotto.ui.ConsoleOutput.*;

public class ConsoleInput {
		public static String readLine() {
			String input = Console.readLine();
			if (input.isEmpty()) {
				PrintErrorMessage(EMPTY);
			}
			return input;
		}
}
