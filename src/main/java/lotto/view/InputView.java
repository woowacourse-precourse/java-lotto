package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

public class InputView {
	private static final String START_GAME_MESSAGE = "구입 금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	public static int inputMoney() {
		System.out.println(START_GAME_MESSAGE);
		String number = Console.readLine();
		validateNumber(number);
		return Integer.parseInt(number);
	}

	public static List<Integer> inputWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);

		List<String> numbers = List.of(Console.readLine().split(","));
		validateNumbers(numbers);

		return toIntegerList(numbers);
	}

	public static int inputBonusNumbers() {
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

		String number=Console.readLine();
		validateNumber(number);

		return Integer.parseInt(number);
	}

	private static void validateNumber(String number) {
		final String REGEX = "[0-9]+";

		if (!number.matches(REGEX)) {
			OutputView.printError(ErrorMessage.NOT_NUMBER_ERROR);
			throw new IllegalArgumentException();
		}
	}

	private static void validateNumbers(List<String> numbers) {
		final String REGEX = "[0-9]+";

		if (!toString(numbers).matches(REGEX)) {
			OutputView.printError(ErrorMessage.NOT_NUMBERS_ERROR);
			throw new IllegalArgumentException();
		}
	}

	private static String toString(List<String> numbers) {
		return numbers.stream().collect(Collectors.joining(""));
	}

	private static List<Integer> toIntegerList(List<String> numbers) {
		return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
	}


}
