package lotto.exception;

public class NumberOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "유효한 범위의 수가 아닙니다.";

    public NumberOutOfRangeException() {
        super(MESSAGE);
    }
}
