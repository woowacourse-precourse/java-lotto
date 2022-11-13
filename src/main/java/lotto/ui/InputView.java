package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.MessageConstants;
import lotto.domain.lotto.LottoDraw;
import lotto.ui.dto.BonusNumber;
import lotto.ui.dto.LottoPurchasedAmount;
import lotto.ui.dto.WinNumbers;
import lotto.util.BonusNumberValidator;
import lotto.util.LottoPurchasedAmountValidator;
import lotto.util.Validator;
import lotto.util.WinNumbersValidator;

public class InputView {

    public LottoPurchasedAmount getLottoPurchasedAmount() {
        String purchasedAmount = getUserInputWithMessage(MessageConstants.PURCHASED_AMOUNT_MESSAGE);
        Validator validator = new LottoPurchasedAmountValidator();
        return new LottoPurchasedAmount(purchasedAmount, validator);
    }

    public LottoDraw getLottoDraw() {
        WinNumbers winNumbers = getWinNumbers();
        BonusNumber bonusNumber = getBonusNumber();

        return LottoDraw.of(winNumbers.asList(), bonusNumber.getNumber());
    }

    private WinNumbers getWinNumbers() {
        String winNumbers = getUserInputWithMessage(MessageConstants.WIN_NUMBER_MESSAGE);

        Validator validator = new WinNumbersValidator();
        return new WinNumbers(winNumbers, validator);
    }

    private BonusNumber getBonusNumber() {
        String bonusNumber = getUserInputWithMessage(MessageConstants.BONUS_NUMBER_MESSAGE);

        Validator validator = new BonusNumberValidator();
        return new BonusNumber(bonusNumber, validator);
    }

    private String getUserInputWithMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
