package lotto;

public class IllegalArgumentError extends IllegalArgumentException {

    public IllegalArgumentError() {
    }

    public IllegalArgumentError(String message, Throwable cause) {

        super("[ERROR] " + message, cause);
    }

    public IllegalArgumentError(String message) {
        super("[ERROR] " + message);
    }
}