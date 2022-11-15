package lotto.exception;

import lotto.constant.ErrorMessage;

public class NotNumberInputException extends IllegalArgumentException {
    public NotNumberInputException() {
        super(ErrorMessage.NOT_INTEGER.getMessage());
    }
}
