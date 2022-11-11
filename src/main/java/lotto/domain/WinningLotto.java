package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
	private static final String WINNING_NUMBER_DELIMITER = ",";

	public static List<String> winningNumber;
	public static List<String> bonusNumber;

	public static void createWinningNumber(String userInput) {
		winningNumber = Arrays.asList(userInput.split(WINNING_NUMBER_DELIMITER));
	}

	public static void createBonusNumber(String userInput) {
		bonusNumber = Arrays.asList(userInput);
	}

	public static List<String> getWinningNumber() {
		return winningNumber;
	}

	public static List<String> getBonusNumber() {
		return bonusNumber;
	}
}
