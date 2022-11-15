package lotto.exception.money;

import static lotto.constant.ErrorMessage.MONEY_NOT_POSITIVE_INTEGER;

import lotto.exception.BaseException;

public class PurchaseMoneyNotPositiveIntegerException extends BaseException {

    public PurchaseMoneyNotPositiveIntegerException() {
        super(MONEY_NOT_POSITIVE_INTEGER);
    }
}
