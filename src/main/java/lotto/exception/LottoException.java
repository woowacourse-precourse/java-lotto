package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public LottoException(String s) {
        super(ERROR_MESSAGE+s);
    }
}
