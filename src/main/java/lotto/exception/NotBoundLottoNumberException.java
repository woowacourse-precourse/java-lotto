package lotto.exception;

public class NotBoundLottoNumberException extends IllegalBaseException {
    static final String MESSAGE = "숫자는 1이상 45이상이어야한다.";

    public NotBoundLottoNumberException() {
        super(MESSAGE);
    }
}
