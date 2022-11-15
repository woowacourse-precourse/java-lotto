package lotto.exception;

import lotto.message.ErrorMessage;

public class OutOfRangeException extends LottoException {

    public OutOfRangeException() {
        super(ErrorMessage.RIGHT_RANGE);
    }
}
