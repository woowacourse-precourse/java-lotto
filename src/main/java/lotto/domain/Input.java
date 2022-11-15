package lotto.domain;


import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class Input {
	public static String getPurchaseAmount() {
		InputView.getPurchaseAmount();
		return Console.readLine();
	}

	public static String getWinningNumber() {
		InputView.getWinningNumber();
		return Console.readLine();
	}

	public static String getBonusNumber() {
		InputView.getBonusNumber();
		return Console.readLine();
	}
}
