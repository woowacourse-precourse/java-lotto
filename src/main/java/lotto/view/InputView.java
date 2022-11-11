package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ViewConst;

public class InputView {

	public String printStart() {
		System.out.println(ViewConst.START_INPUT);
		return Console.readLine();
	}

	public String printWinnerNumber() {
		System.out.println(ViewConst.WIN_NUMBER_INPUT);
		return Console.readLine();
	}

	public String bonusNumber() {
		System.out.println(ViewConst.BONUS_INPUT);
		return Console.readLine();
	}

}
