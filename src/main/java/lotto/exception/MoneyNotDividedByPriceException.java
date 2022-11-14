package lotto.exception;

import static lotto.constant.ErrorMessage.MONEY_NOT_DIVIDED_BY_PRICE;

public class MoneyNotDividedByPriceException extends BaseException {

    public MoneyNotDividedByPriceException() {
        super(MONEY_NOT_DIVIDED_BY_PRICE);
    }
}
