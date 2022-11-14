package lotto.exception;

public class IllegalBaseException extends IllegalArgumentException {
    private static final String TAG = "[ERROR] ";

    public IllegalBaseException(String message) {
        super(TAG + message);
    }
}
