package lotto.view.exception;

public class CantFirstNumberZeroException extends IllegalArgumentException {

    public CantFirstNumberZeroException() {
        super("[ERROR] 첫 숫자로 0이 올 수 없습니다.");
    }
}
