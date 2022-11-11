package lotto.exception;

public class NotNumberException extends IllegalArgumentException {
    private static final String message = "숫자가 아닙니다.";

    public NotNumberException() {
        super(message);
    }
}
