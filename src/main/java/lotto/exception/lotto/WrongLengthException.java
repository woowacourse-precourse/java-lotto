package lotto.exception.lotto;

import static lotto.constant.ErrorMessage.WRONG_LENGTH;

import lotto.exception.BaseException;

public class WrongLengthException extends BaseException {

    public WrongLengthException() {
        super(WRONG_LENGTH);
    }
}
