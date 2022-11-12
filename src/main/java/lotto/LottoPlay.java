package lotto;

import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidationUtil;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();

    private final InputUtil inputUtil = new InputUtil();

    private final ValidationUtil validationUtil = new ValidationUtil();

    public void play() {
        messageUtil.printBonusInput();
        getUserPurchaseAmount();
    }

    private int getUserPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(inputUtil.getUserInput());
        validationUtil.validatePurchase(purchaseAmount);
        return purchaseAmount;
    }

}

