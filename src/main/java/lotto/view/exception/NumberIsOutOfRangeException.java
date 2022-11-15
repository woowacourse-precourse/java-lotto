package lotto.view.exception;

public class NumberIsOutOfRangeException extends IllegalArgumentException {
    public NumberIsOutOfRangeException() {
        super("[Error] 1~45 사이의 숫자로만 이루어진 수를 입력할 수 있습니다.");
    }
}
