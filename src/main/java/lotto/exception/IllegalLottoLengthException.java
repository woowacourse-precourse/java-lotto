package lotto.exception;

import lotto.lotto.Lotto;

public class IllegalLottoLengthException extends IllegalArgumentException {
    public IllegalLottoLengthException() {
        super(String.format("로또 번호는 %d개여야 합니다.", Lotto.LOTTO_MAX_SIZE));
    }
}
