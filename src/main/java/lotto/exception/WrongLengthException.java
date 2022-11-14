package lotto.exception;

import static lotto.constant.ErrorMessage.WRONG_LENGTH;

public class WrongLengthException extends BaseException {

    public WrongLengthException() {
        super(WRONG_LENGTH);
    }
}
