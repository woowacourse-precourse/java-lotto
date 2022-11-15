package lotto.exception;

import static lotto.constant.ErrorMessage.MONEY_NOT_POSITIVE_INTEGER;

public class MoneyNotPositiveIntegerException extends BaseException {

    public MoneyNotPositiveIntegerException() {
        super(MONEY_NOT_POSITIVE_INTEGER);
    }
}
