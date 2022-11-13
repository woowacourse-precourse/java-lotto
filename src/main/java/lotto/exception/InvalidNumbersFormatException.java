package lotto.exception;

public class InvalidNumbersFormatException extends IllegalArgumentException {
    private static final String MESSAGE = "잘못된 로또 번호 입력 형식입니다.";

    public InvalidNumbersFormatException() {
        super(MESSAGE);
    }
}
