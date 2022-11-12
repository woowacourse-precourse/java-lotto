package lotto.exception.domain;

import lotto.exception.LottoException;

public class LottoNumberDuplicateException extends LottoException {
    private static final String LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public LottoNumberDuplicateException() {
        super(LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
    }
}
