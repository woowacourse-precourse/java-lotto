package exception;

import static validation.Validator.ERROR_MESSAGE;

public class InvalidBonusNumberException extends IllegalArgumentException {
    public InvalidBonusNumberException() {
        super(ERROR_MESSAGE + "당첨 번호와 중복되지 않는 보너스 번호를 입력해주세요.");
    }
}
