package lotto.view.exception;

public class OnlySixNumberInputException extends IllegalArgumentException {
    public OnlySixNumberInputException() {
        super("[ERROR] 6개의 수만 입력할 수 있습니다.");
    }
}
