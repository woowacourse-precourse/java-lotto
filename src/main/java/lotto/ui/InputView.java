package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.MessageConstants;
import lotto.ui.dto.LottoPurchasedAmount;
import lotto.util.Validator;

public class InputView {
	private final Validator lottoPurchasedAmountValidator;

	public InputView(Validator validator) {
		this.lottoPurchasedAmountValidator = validator;
	}

	public LottoPurchasedAmount getLottoPurchasedAmount() {
		System.out.println(MessageConstants.PURCHASED_AMOUNT_MESSAGE); //FIXME: 역할 분리
		String userInput = Console.readLine();
		return new LottoPurchasedAmount(userInput, lottoPurchasedAmountValidator);
	}
}
