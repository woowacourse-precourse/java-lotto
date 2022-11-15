package exception;

import static validation.Validator.ERROR_MESSAGE;

public class NotIntegerException extends IllegalArgumentException {
    public NotIntegerException() {
        super(ERROR_MESSAGE + "정수로 입력해 주세요.");
    }
}
