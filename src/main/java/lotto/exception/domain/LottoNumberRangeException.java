package lotto.exception.domain;

import lotto.exception.LottoException;

public class LottoNumberRangeException extends LottoException {
    private static final String LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "로또 번호는 %s부터 %s까지 입니다.";

    public LottoNumberRangeException(int lottoNumberMin, int lottoNumberMax) {
        super(String.format(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE, lottoNumberMin, lottoNumberMax));
    }
}
