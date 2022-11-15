package exception;

import static validation.Validator.ERROR_MESSAGE;

public class NotInUnitsOf1000WonException extends IllegalArgumentException {
    public NotInUnitsOf1000WonException() {
        super(ERROR_MESSAGE + 1000 + "원 단위의 금액을 입력해 주세요.");
    }
}
