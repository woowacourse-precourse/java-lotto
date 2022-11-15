package lotto.exception.lotto;

import static lotto.constant.ErrorMessage.NOT_DISTINCT;

import lotto.exception.BaseException;

public class NotDistinctException extends BaseException {

    public NotDistinctException() {
        super(NOT_DISTINCT);
    }
}
