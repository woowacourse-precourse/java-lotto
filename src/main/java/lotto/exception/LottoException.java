package lotto.exception;


import lotto.ui.Message;

public class LottoException extends IllegalArgumentException {
    public LottoException(String msg) {
        if (msg.isBlank()) {
            msg = Message.UNEXPECTED_ERROR;
        }
        throw new IllegalArgumentException(Message.ERROR_MESSAGE + msg);
    }
}
