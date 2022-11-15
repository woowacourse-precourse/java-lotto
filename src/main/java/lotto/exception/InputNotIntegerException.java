package lotto.exception;

public class InputNotIntegerException extends IllegalArgumentException {
    private static final String MESSAGE = "입력값이 숫자가 아닙니다.";

    public InputNotIntegerException() {
        super(MESSAGE);
    }
}
