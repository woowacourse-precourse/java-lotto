package lotto.exception.money;

import static lotto.constant.ErrorMessage.PURCHASE_MONEY_WRONG_RANGE;

import lotto.exception.BaseException;

public class PurchaseMoneyRangeException extends BaseException {

    public PurchaseMoneyRangeException() {
        super(PURCHASE_MONEY_WRONG_RANGE);
    }
}
