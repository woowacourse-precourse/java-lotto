package lotto.view.exception;

public class OnlyNumberConsistBetweenOneToNineInputException extends IllegalArgumentException {
    public OnlyNumberConsistBetweenOneToNineInputException() {
        super("[ERROR] 0~9사이의 숫자로만 이루어진 수를 입력할 수 있습니다.");
    }
}
