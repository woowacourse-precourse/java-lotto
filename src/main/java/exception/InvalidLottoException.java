package exception;

import static validation.Validator.ERROR_MESSAGE;

import lotto.Lotto;

public class InvalidLottoException extends IllegalArgumentException {
    public InvalidLottoException() {
        super(ERROR_MESSAGE + "로또 형식에 맞는 숫자를 입력해 주세요.("
                + Lotto.FIRST_NUMBER + " ~ "
                + Lotto.LAST_NUMBER + " 숫자 중 중복되지 않는 "
                + Lotto.SIZE + "개의 숫자)");
    }
}
