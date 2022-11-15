package exception;

import static validation.Validator.ERROR_MESSAGE;

public class InvalidLottoSizeException extends IllegalArgumentException {
    public InvalidLottoSizeException() {
        super(ERROR_MESSAGE + "로또 번호는 6개 입니다.");
    }
}
