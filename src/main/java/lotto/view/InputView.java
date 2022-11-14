package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

	private static final String INPUT_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";

	public int inputBudget() {
		printMessage(INPUT_BUDGET_MESSAGE);
		String input = Console.readLine();
		validateNumber(input);
		return Integer.parseInt(input);
	}

	private void printMessage(String message) {
		System.out.println(message);
	}

	private void validateNumber(String input) {
		if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
			throw new IllegalArgumentException();
		}
	}
}
