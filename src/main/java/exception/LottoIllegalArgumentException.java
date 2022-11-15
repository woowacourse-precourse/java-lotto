package exception;

public class LottoIllegalArgumentException extends IllegalArgumentException {
    private String message;

    public LottoIllegalArgumentException(String message) {
        super(ExceptionUtil.ERROR_PREFIX + message);
    }
}
