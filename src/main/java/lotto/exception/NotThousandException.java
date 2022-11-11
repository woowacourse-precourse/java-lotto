package lotto.exception;

public class NotThousandException extends IllegalArgumentException {
    private static final String message = "1000단위 숫자가 아닙니다.";

    public NotThousandException() {
        super(message);
    }
}
