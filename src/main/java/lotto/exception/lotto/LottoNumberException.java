package lotto.exception.lotto;

import static lotto.constant.ErrorMessage.WRONG_LOTTO_NUMBER;

import lotto.exception.BaseException;

public class LottoNumberException extends BaseException {

    public LottoNumberException() {
        super(WRONG_LOTTO_NUMBER);
    }
}
