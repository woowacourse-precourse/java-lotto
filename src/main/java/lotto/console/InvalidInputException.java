package lotto.console;

public class InvalidInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public InvalidInputException(String errorString) {
        super(String.format(ERROR_MESSAGE, errorString));
    }
}
