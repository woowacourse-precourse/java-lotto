package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.MessageConstants;
import lotto.ui.dto.LottoDraw;
import lotto.ui.dto.LottoPurchasedAmount;
import lotto.util.Validator;

public class InputView {
	private final Validator lottoPurchasedAmountValidator;
	private final Validator lottoDrawValidator;

	public InputView(Validator lottoPurchasedAmountValidator, Validator lottoDrawValidator) {
		this.lottoPurchasedAmountValidator = lottoPurchasedAmountValidator;
		this.lottoDrawValidator = lottoDrawValidator;
	}

	public LottoPurchasedAmount getLottoPurchasedAmount() {
		System.out.println(MessageConstants.PURCHASED_AMOUNT_MESSAGE); //FIXME: 역할 분리
		String userInput = Console.readLine();
		return new LottoPurchasedAmount(userInput, lottoPurchasedAmountValidator);
	}

	public LottoDraw getLottoDraw() {
        String winNumbers = getWinNumbers();
        String bonusNumber = getBonusNumber();
    }

	private String getWinNumbers() {
		System.out.println(MessageConstants.WIN_NUMBER_MESSAGE);
		return Console.readLine();
	}

    private String getBonusNumber() {
        System.out.println(MessageConstants.BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
