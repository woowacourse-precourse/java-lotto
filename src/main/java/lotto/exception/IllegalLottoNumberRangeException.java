package lotto.exception;

import lotto.lotto.Lotto;

public class IllegalLottoNumberRangeException extends IllegalArgumentException {
    public IllegalLottoNumberRangeException() {
        super(String.format("로또 번호는 [%d, %d] 사이의 숫자여야 합니다.", Lotto.LOTTO_NUMBER_LOWER_BOUND, Lotto.LOTTO_NUMBER_UPPER_BOUND));
    }
}
