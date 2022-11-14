package lotto.exception;

import static lotto.constant.ErrorMessage.HEADER;

public class BaseException extends IllegalArgumentException {

    public BaseException(String message) {
        super(HEADER + message);
    }
}
