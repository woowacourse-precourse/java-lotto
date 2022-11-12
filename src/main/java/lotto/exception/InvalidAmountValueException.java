package lotto.exception;

public class InvalidAmountValueException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 구입 금액이 1000으로 나누어지지 않습니다.";

    public InvalidAmountValueException() {
        super(MESSAGE);
    }
}
