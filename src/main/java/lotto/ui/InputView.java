package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.MessageConstants;
import lotto.ui.dto.BonusNumber;
import lotto.domain.lotto.LottoDraw;
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
        String purchasedAmount = getUserInputWithMessage(MessageConstants.PURCHASED_AMOUNT_MESSAGE);
        return new LottoPurchasedAmount(purchasedAmount, lottoPurchasedAmountValidator);
    }

    public LottoDraw getLottoDraw() {
        WinNumbers winNumbers = getWinNumbers();
        BonusNumber bonusNumber = getBonusNumber();

        return LottoDraw.of(winNumbers, bonusNumber);
    }

    private WinNumbers getWinNumbers() {
        String winNumbers = getUserInputWithMessage(MessageConstants.WIN_NUMBER_MESSAGE);
        return new WinNumbers(winNumbers, winNumbersValidator);
    }

    private BonusNumber getBonusNumber() {
        String bonusNumber = getUserInputWithMessage(MessageConstants.BONUS_NUMBER_MESSAGE);
        return new BonusNumber(bonusNumber, bonusNumberValidator);
    }

    private String getUserInputWithMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
