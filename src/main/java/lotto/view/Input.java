package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static String buyLotto() {
		final String quantity = Console.readLine();

		return quantity;
	}

	public static String pickWinningNumbers() {
		final String lottoNumbers = Console.readLine();

		return lottoNumbers;
	}
}
