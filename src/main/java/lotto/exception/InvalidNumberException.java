package lotto.exception;

public class InvalidNumberException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_NO_NUMBER = "[ERROR] 숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";

    public InvalidNumberException() {
        super(EXCEPTION_MESSAGE_NO_NUMBER);
    }
}
