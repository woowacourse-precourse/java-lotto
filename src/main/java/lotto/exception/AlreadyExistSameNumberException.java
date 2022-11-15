package lotto.exception;

import lotto.message.ErrorMessage;

public class AlreadyExistSameNumberException extends LottoException {

    public AlreadyExistSameNumberException() {
        super(ErrorMessage.ALREADY_EXIST_NUMBER);
    }
}
