package lotto.exception;

public class DuplicatedLottoNumberException extends IllegalArgumentException {
    public DuplicatedLottoNumberException() {
        super("로또 번호는 서로 달라야합니다.");
    }
}
