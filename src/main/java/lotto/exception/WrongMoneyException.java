package lotto.exception;

import static lotto.constant.ErrorMessage.WRONG_MONEY;

public class WrongMoneyException extends BaseException {

    public WrongMoneyException() {
        super(WRONG_MONEY);
    }
}
