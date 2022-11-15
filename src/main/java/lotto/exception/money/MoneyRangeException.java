package lotto.exception.money;

import static lotto.constant.ErrorMessage.MONEY_WRONG_RANGE;

import lotto.exception.BaseException;

public class MoneyRangeException extends BaseException {

    public MoneyRangeException() {
        super(MONEY_WRONG_RANGE);
    }
}
