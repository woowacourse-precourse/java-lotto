package lotto.domain.ui;

import lotto.domain.model.Message;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Scanner {
	int integer;
	String string;

	public int scanInt() {
		String input = readLine();
		validateInt(input);
		return integer;
	}

	public void scanString() {
		String input = readLine();
		string = input;
	}

	void validateInt(String input) {
		try {
			integer = Integer.parseInt(input);
		} catch (IllegalArgumentException exception) {
			new Printer().printMessage(Message.ERROR);
			throw new IllegalArgumentException();
		}
	}
}
