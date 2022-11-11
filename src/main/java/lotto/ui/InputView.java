package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.MessageConstants;
import lotto.ui.dto.BonusNumber;
import lotto.ui.dto.LottoDraw;
import lotto.ui.dto.LottoPurchasedAmount;
import lotto.ui.dto.WinNumbers;
import lotto.util.Validator;

public class InputView {
	private final Validator lottoPurchasedAmountValidator;
	private final Validator winNumbersValidator;
	private final Validator bonusNumberValidator;

	public InputView(Validator lottoPurchasedAmountValidator,
					 Validator winNumbersValidator,
					 Validator bonusNumberValidator) {

		this.lottoPurchasedAmountValidator = lottoPurchasedAmountValidator;
		this.winNumbersValidator = winNumbersValidator;
		this.bonusNumberValidator = bonusNumberValidator;
	}

	public LottoPurchasedAmount getLottoPurchasedAmount() {
		System.out.println(MessageConstants.PURCHASED_AMOUNT_MESSAGE); //FIXME: 역할 분리
		String userInput = Console.readLine();
		return new LottoPurchasedAmount(userInput, lottoPurchasedAmountValidator);
	}

	public LottoDraw getLottoDraw() {
		WinNumbers winNumbers = getWinNumbers();
		BonusNumber bonusNumber = getBonusNumber();

		return LottoDraw.of(winNumbers, bonusNumber);
	}

	private WinNumbers getWinNumbers() {
	}

    private BonusNumber getBonusNumber() {
    }
}
