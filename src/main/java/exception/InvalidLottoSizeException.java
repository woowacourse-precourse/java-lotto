package exception;

import static validation.Validator.ERROR_MESSAGE;

import lotto.Lotto;

public class InvalidLottoSizeException extends IllegalArgumentException {
    public InvalidLottoSizeException() {
        super(ERROR_MESSAGE + "로또 번호는 " + Lotto.SIZE + "개 입니다.");
    }
}
