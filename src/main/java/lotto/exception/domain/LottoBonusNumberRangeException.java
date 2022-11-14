package lotto.exception.domain;

import lotto.exception.LottoException;

public class LottoBonusNumberRangeException extends LottoException {
    private static final String LOTTO_BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE = "로또 보너스 번호는 %s부터 %s까지 입니다.";

    public LottoBonusNumberRangeException(int lottoBonusNumberMin, int lottoBonusNumberMax) {
        super(String.format(LOTTO_BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE, lottoBonusNumberMin, lottoBonusNumberMax));
    }
}
