package lotto.exception.winningNums;

public class InputNumsDuplicatedException extends IllegalArgumentException{
    public InputNumsDuplicatedException() {
        super("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
    }
}
