package lotto.exception;

public class ZeroMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 0원 이상이어야 합니다.";

    public ZeroMoneyException() {
        super(ERROR_MESSAGE);
    }
}
