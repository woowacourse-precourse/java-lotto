package lotto.exception;


import lotto.ui.Message;

public class LottoException extends IllegalArgumentException {
    public LottoException(String msg) {
        super(Message.ERROR_MESSAGE + msg);
    }
}
