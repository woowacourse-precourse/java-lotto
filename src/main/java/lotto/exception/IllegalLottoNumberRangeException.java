package lotto.exception;

public class IllegalLottoNumberRangeException extends IllegalArgumentException {
    public IllegalLottoNumberRangeException() {
        super("로또 번호는 [1, 45] 사이의 숫자여야 합니다.");
    }
}
