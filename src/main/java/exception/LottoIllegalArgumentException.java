package exception;

public class LottoIllegalArgumentException {

    private static final String PREFIX_ERROR = "[ERROR] ";
    private String message;

    public LottoIllegalArgumentException(String message) {
        this.message = message;
        System.out.println(PREFIX_ERROR + message);
    }
}
