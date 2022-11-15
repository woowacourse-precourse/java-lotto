package lotto.exception;

import lotto.LottoGame.LottoGame;

public class IllegalPriceUnitException extends IllegalArgumentException {
    public IllegalPriceUnitException() {
        super(String.format("로또를 구입할 금핵이 %d원 단위가 아닙니다.", LottoGame.PRICE_UNIT));
    }
}
