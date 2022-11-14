package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.util.Validator;

public class ConsoleInput {

	public String readLine() {
		String input = Console.readLine();
		Validator.validateInputNotEmpty(input);
		return input;
	}
}
