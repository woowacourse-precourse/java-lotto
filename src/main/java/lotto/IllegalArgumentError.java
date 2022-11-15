package lotto;

public class IllegalArgumentError extends IllegalArgumentException {

    public IllegalArgumentError(String message) {
        super("[ERROR] " + message);
    }
}