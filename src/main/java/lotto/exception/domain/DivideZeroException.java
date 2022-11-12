package lotto.exception.domain;

import lotto.exception.LottoException;

public class DivideZeroException extends LottoException {
    private static final String DIVIDE_ZERO_EXCEPTION_MESSAGE = "0으로 나눌 수 없습니다.";

    public DivideZeroException() {
        super(DIVIDE_ZERO_EXCEPTION_MESSAGE);
    }
}
