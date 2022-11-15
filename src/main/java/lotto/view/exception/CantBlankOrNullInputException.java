package lotto.view.exception;

public class CantBlankOrNullInputException extends IllegalArgumentException {
    public CantBlankOrNullInputException() {
        super("[ERROR] null 이나 빈값이 들어올 수 없습니다.");
    }
}
