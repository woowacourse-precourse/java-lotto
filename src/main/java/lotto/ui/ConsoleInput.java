package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import static lotto.ui.ConsoleOutput.*;

public class ConsoleInput {
		public static String readLine() {
			String input = Console.readLine();
			validateIsEmpty(input);
			return input;
		}

	private static void validateIsEmpty(String input) {
		if (input.isEmpty()) {
			PrintErrorMessage(EMPTY);
			throw new IllegalArgumentException();
		}
	}
}
