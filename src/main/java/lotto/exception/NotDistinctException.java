package lotto.exception;

import static lotto.constant.ErrorMessage.NOT_DISTINCT;

public class NotDistinctException extends BaseException {

    public NotDistinctException() {
        super(NOT_DISTINCT);
    }
}
