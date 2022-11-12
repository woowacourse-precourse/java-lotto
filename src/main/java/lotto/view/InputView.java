package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.OutputMessage;

public class InputView {
	public String getPurchasingAmount() {
		return Console.readLine();
	}

	private void printAskingPurchasingAmountMessage() {
		System.out.println(OutputMessage.ASKING_PURCHASING_AMOUNT.message());
	}


}
