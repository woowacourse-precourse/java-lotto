package lotto.common.exception;

public class BaseException extends IllegalArgumentException {
    final static String TAG = "[ERROR] ";
    public BaseException() {
    }

    public BaseException(String s) {
        super(TAG+s);
    }
}
