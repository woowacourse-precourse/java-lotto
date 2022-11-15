package lotto.exception;

import lotto.message.ErrorMessage;

public class InputWrongPurchaseMoneyException extends LottoException {

    public InputWrongPurchaseMoneyException() {
        super(ErrorMessage.WRONG_PURCHASE_MONEY);
    }
}
