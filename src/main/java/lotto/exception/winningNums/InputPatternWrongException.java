package lotto.exception.winningNums;

public class InputPatternWrongException extends IllegalArgumentException{
    public InputPatternWrongException() {
        super("[ERROR] 입력하신 문자열의 패턴이 올바르지 않습니다.");
    }
}
