package exception;

import static validation.Validator.ERROR_MESSAGE;

public class LottoNumberDuplicatedException extends IllegalArgumentException {
    public LottoNumberDuplicatedException() {
        super(ERROR_MESSAGE + "로또 번호에 중복된 숫자가 있습니다.");
    }
}
