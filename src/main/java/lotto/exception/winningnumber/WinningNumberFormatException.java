package lotto.exception.winningnumber;

public class WinningNumberFormatException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_INVALID_FORMAT = "[ERROR] 잘못된 형식의 입력입니다.";

    public WinningNumberFormatException() {
        super(EXCEPTION_MESSAGE_INVALID_FORMAT);
    }
}
