package lotto.exception;

import static lotto.constant.ErrorMessage.MONEY_WRONG_RANGE;

public class MoneyRangeException extends BaseException {

    public MoneyRangeException() {
        super(MONEY_WRONG_RANGE);
    }
}
