package lotto.domain.player.exception;

import lotto.utils.message.ExceptionMessageUtil;

public class WrongGeneratorException extends RuntimeException {

    public WrongGeneratorException() {
        super(ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
    }
}
