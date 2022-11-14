package lotto.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public CustomIllegalArgumentException(Error error) {
        super(error.getMessage());
    }
}
