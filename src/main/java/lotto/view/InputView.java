package lotto.view;

import static lotto.ErrorMessage.INVALID_NUMBER_ERROR_MESSAGE;
import static lotto.ErrorMessage.INVALID_WINNING_NUMBER_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

	private static final String INPUT_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";
	private static final String WINNING_NUMBER_REGEX = "^([0-9]{1,2},){5}[0-9]{1,2}$";

	private static final String SEPARATOR = ",";

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
			throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
		}
	}

	public List<Integer> inputWinningNumber() {
		printMessage(INPUT_WINNING_NUMBER_MESSAGE);
		String input = Console.readLine();
		validateWinningNumber(input);
		return toIntegerList(input);
	}


	private void validateWinningNumber(String input) {
		if (!Pattern.matches(WINNING_NUMBER_REGEX, input)) {
			throw new IllegalArgumentException(INVALID_WINNING_NUMBER_ERROR_MESSAGE);
		}
	}

	private List<Integer> toIntegerList(String input) {
		return Arrays.stream(input.split(SEPARATOR))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public int inputBonusNumber() {
		printMessage(INPUT_BONUS_NUMBER_MESSAGE);
		String input = Console.readLine();
		validateNumber(input);
		return Integer.parseInt(input);
	}
}
