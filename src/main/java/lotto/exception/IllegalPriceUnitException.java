package lotto.exception;

public class IllegalPriceUnitException extends IllegalArgumentException {
    public IllegalPriceUnitException() {
        super("로또를 구입할 금핵이 1000원 단위가 아닙니다.");
    }
}
