package lotto.exception.winningNums;

public class InputNumRangeException extends IllegalArgumentException{
    public InputNumRangeException() {
        super("[ERROR] 1-45까지의 숫자만 입력해야 합니다.");
    }
}
