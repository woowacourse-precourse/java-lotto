package lotto.exception;

public class InvalidSizeException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값의 갯수가 일치하지 않습니다.";

    public InvalidSizeException() {
        super(MESSAGE);
    }
}
