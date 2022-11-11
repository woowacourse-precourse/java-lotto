package lotto.exception;

import lotto.constant.ErrorMessage;

public class IllegalMoneyInputException extends IllegalArgumentException {
    public IllegalMoneyInputException() {
        super(ErrorMessage.NOT_DIVISIBLE.getMessage());
    }
}
