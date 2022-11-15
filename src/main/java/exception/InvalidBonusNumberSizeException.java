package exception;

import static validation.Validator.ERROR_MESSAGE;

public class InvalidBonusNumberSizeException extends IllegalArgumentException {
    public InvalidBonusNumberSizeException() {
        super(ERROR_MESSAGE + "보너스 번호는 1개 입니다.");
    }
}
