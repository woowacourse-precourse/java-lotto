package lotto.exception;

import static lotto.constant.ErrorMessage.WRONG_LOTTO_NUMBER;

public class LottoNumberException extends BaseException {

    public LottoNumberException() {
        super(WRONG_LOTTO_NUMBER);
    }
}
