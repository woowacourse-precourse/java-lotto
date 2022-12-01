package lotto.exception;

public class MyIllegalArgumentException extends IllegalArgumentException {
    private final static String PREFIX = "[ERROR] ";

    public MyIllegalArgumentException(ErrorCode errorCode) {
        super(errorCode.message);
    }

    public void printErrorMessage() {
        System.out.println(PREFIX + getMessage());
    }
}
