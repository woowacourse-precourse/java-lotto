package lotto.exception;

public class IllegalLottoException extends IllegalBaseException {
    static final String MESSAGE = "로또는 중복되지않은 6개여야합니다.";

    public IllegalLottoException() {
        super(MESSAGE);
    }
}
