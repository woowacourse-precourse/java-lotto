package lotto.view.exception;

import lotto.utils.message.ExceptionMessageUtil;

public class NotFoundViewException extends RuntimeException {

    public NotFoundViewException() {
        super(ExceptionMessageUtil.NOT_FOUND_VIEW.findFullMessage());
    }
}
