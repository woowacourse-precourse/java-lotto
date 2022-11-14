package exception;

public class MoneyIllegalArgumentException extends IllegalArgumentException {
    private String message;

    public MoneyIllegalArgumentException(String message) {
        super(message);
    }
}
