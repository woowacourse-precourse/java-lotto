package exception;

import exception.type.CustomIllegalArgumentException;

public class MoneyIllegalArgumentException extends CustomIllegalArgumentException {
    private String message;

    public MoneyIllegalArgumentException(String message) {
        super(message);
    }
}
