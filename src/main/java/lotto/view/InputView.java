package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class InputView {
	public String getPurchasingAmount() {
		return Console.readLine();
	}

	private void printAskingPurchasingAmountMessage() {
		System.out.println(Message.ASKING_PURCHASING_AMOUNT.message());
	}


}
