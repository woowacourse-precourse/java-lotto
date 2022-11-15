package lotto.exception;

public class NumbersNotMatchDigitException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 로또의 필요 숫자 개수는 6개 입니다.";

    public NumbersNotMatchDigitException() {
        super(MESSAGE);
    }
}
