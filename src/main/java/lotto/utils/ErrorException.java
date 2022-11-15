package lotto.utils;

public class ErrorException extends IllegalArgumentException {
    public ErrorException() {
    }

    public ErrorException(String s) {
        super(s);
    }

    public ErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorException(Throwable cause) {
        super(cause);
    }
}
