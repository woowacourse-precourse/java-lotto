package lotto.exception;

public class IllegalResultLottoException extends IllegalBaseException {
    static final String MESSAGE = "결과 로또는 중복되지않은 7개여야합니다.";

    public IllegalResultLottoException() {
        super(MESSAGE);
    }
}
