package exception;

import static lotto.Lotto.FIRST_NUMBER;
import static lotto.Lotto.LAST_NUMBER;
import static validation.Validator.ERROR_MESSAGE;

public class InvalidRangeException extends IllegalArgumentException {
    public InvalidRangeException() {
        super(ERROR_MESSAGE + "로또 번호는 " + FIRST_NUMBER + "부터 " + LAST_NUMBER + " 사이의 숫자여야 합니다.");
    }
}
