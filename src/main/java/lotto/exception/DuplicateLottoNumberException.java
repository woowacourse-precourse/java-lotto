package lotto.exception;

import lotto.constant.ErrorMessage;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    public DuplicateLottoNumberException() {
        super(ErrorMessage.DUPLICATE.getMessage());
    }
}
