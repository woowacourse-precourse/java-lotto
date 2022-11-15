package lotto.exception;

public class InputNonDivisibleException extends IllegalArgumentException {
    private static final String MESSAGE = "구입금액이 1000원 단위가 아닙니다.";

    public InputNonDivisibleException() {
        super(MESSAGE);
    }
}
