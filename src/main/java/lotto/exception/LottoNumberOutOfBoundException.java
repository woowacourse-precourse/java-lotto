package lotto.exception;

import lotto.constant.ErrorMessage;

public class LottoNumberOutOfBoundException extends IllegalArgumentException {
    public LottoNumberOutOfBoundException() {
        super(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
    }
}
