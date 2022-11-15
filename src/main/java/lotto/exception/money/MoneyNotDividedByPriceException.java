package lotto.exception.money;

import static lotto.constant.ErrorMessage.MONEY_NOT_DIVIDED_BY_PRICE;

import lotto.exception.BaseException;

public class MoneyNotDividedByPriceException extends BaseException {

    public MoneyNotDividedByPriceException() {
        super(MONEY_NOT_DIVIDED_BY_PRICE);
    }
}
