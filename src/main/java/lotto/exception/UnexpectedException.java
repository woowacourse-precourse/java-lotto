package lotto.exception;

import lotto.constant.ErrorMessage;

public class UnexpectedException extends IllegalArgumentException{
    public UnexpectedException() {
        super(ErrorMessage.UNEXPECTED.getMessage());
    }
}
