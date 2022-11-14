package lotto.exception;

public class SingleNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닌 다른 입력값이 들어왔습니다.";

    public SingleNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
