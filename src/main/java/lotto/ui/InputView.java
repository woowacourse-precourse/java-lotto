package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.MessageConstants;
import lotto.ui.dto.LottoPurchasedAmount;

public class InputView {

	public LottoPurchasedAmount getLottoPurchasedAmount() {
		System.out.println(MessageConstants.PURCHASED_AMOUNT_MESSAGE);
		String userInput = Console.readLine();
		return new LottoPurchasedAmount(userInput);
	}
}
