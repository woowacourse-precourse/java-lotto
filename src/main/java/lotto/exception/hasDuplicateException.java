package lotto.exception;

public class hasDuplicateException extends IllegalArgumentException {
    private static final String MESSAGE = "숫자의 중복이 존재합니다.";

    public hasDuplicateException() {
        super(MESSAGE);
    }
}
