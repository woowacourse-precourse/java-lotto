package lotto.exception.money;

import static lotto.constant.ErrorMessage.PURCHASE_MONEY_NOT_DIVIDED_BY_PRICE;

import lotto.exception.BaseException;

public class PurchaseMoneyNotDividedByPriceException extends BaseException {

    public PurchaseMoneyNotDividedByPriceException() {
        super(PURCHASE_MONEY_NOT_DIVIDED_BY_PRICE);
    }
}
