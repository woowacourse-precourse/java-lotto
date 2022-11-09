package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static String buyLotto() {
		final String quantity = Console.readLine();

		return quantity;
	}

	public static String pickWinningNumbers() {
		final String winningNumbers = Console.readLine();

		return winningNumbers;
	}

	public static String pickBonusNumbers() {
		final String bonusNumbers = Console.readLine();

		return bonusNumbers;
	}
}
