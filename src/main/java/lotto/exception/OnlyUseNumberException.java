package lotto.exception;

import lotto.message.ErrorMessage;

public class OnlyUseNumberException extends LottoException {

    public OnlyUseNumberException() {
        super(ErrorMessage.ONLY_CAN_USE_NUMBER);
    }
}
