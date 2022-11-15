package lotto.exception;

public class IllegalLottoLengthException extends IllegalArgumentException {
    public IllegalLottoLengthException() {
        super("로또 번호는 6개여야 합니다.");
    }
}
