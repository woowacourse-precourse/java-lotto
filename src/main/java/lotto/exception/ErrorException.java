package lotto.exception;

public class ErrorException extends IllegalArgumentException {
    private final ErrorMessage errorMessage;

    public ErrorException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
