package lotto.domain.view;

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
			new Print().message(Message.ERROR);	// todo errormessage
			throw new IllegalArgumentException();
		}
	}
}
