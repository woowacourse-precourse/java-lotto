package exception;

import static validation.Validator.ERROR_MESSAGE;

public class UndefinedException extends IllegalArgumentException {
    public UndefinedException() {
        super(ERROR_MESSAGE + "입력값이 비어있지는 않은지 확인해 주세요.");
    }
}
