package lotto.exception;

public class IllegalMoneyException extends IllegalBaseException {
    static final String MESSAGE = "입력한 돈은 천단위의 자연수가아닙니다.";

    public IllegalMoneyException() {
        super(MESSAGE);
    }
}
