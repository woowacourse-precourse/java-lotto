package lotto;

public class LottoException extends IllegalArgumentException {

    public LottoException() {
    }

    public LottoException(String s) {
        super(s);
    }

    public LottoException(String message, Throwable cause) {
        super(message, cause);
    }

    public LottoException(Throwable cause) {
        super(cause);
    }

    public LottoException(ErrorResponse errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}
