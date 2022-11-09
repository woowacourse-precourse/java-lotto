package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String inputMoney() {
		OutputView.printStartMessage();
		String money=Console.readLine();

		return money;
	}


}
