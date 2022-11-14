package exception;

import exception.type.CustomIllegalArgumentException;

public class LottoIllegalArgumentException extends CustomIllegalArgumentException {
    private String message;

    public LottoIllegalArgumentException(String message) {
        super(message);
    }
}
