package lotto.exception.domain;

import lotto.exception.LottoException;

public class WinningLottoNumberDuplicateException extends LottoException {
    private static final String WINNING_LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE
            = "당첨 로또는 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑아야 합니다.";

    public WinningLottoNumberDuplicateException() {
        super(WINNING_LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
    }
}
