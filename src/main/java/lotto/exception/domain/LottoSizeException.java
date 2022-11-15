package lotto.exception.domain;

import lotto.exception.LottoException;

public class LottoSizeException extends LottoException {
    private static final String LOTTO_SIZE_EXCEPTION_MESSAGE = "로또 사이즈는 %s여아 합니다.";

    public LottoSizeException(int lottoSize) {
        super(String.format(LOTTO_SIZE_EXCEPTION_MESSAGE, lottoSize));
    }
}
