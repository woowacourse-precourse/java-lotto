package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String inputAmount() {
		OutputView.printAmountMessage();
		return Console.readLine();
	}
}
