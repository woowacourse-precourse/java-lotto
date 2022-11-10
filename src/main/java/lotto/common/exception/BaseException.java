package lotto.common.exception;

public class BaseException extends IllegalArgumentException {
    final static String MSG = "[[ERROR]] ";
    public BaseException() {
    }

    public BaseException(String s) {
        super(MSG+s);
    }
}
