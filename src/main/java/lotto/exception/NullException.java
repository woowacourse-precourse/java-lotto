package lotto.exception;

public class NullException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "1개 이상의 값이 포함되어야 한다.";

    public NullException() {
        super(ERROR_MESSAGE);
    }
}
