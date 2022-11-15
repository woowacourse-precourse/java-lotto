package exception;

import static validation.Validator.ERROR_MESSAGE;

public class InvalidRangeException extends IllegalArgumentException {
    public InvalidRangeException() {
        super(ERROR_MESSAGE + "로또 번호는 " + 1 + "부터 " + 45 + " 사이의 숫자여야 합니다.");
    }
}
