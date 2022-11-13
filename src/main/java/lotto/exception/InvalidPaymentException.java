package lotto.exception;

public class InvalidPaymentException extends IllegalArgumentException {
    private static final String MESSAGE = "적절하지 않은 구입금액입니다.";

    public InvalidPaymentException() {
        super(MESSAGE);
    }
}
