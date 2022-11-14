package lotto.exception;

public class CheckNumberRangeException extends IllegalArgumentException{
    public CheckNumberRangeException() {
        super("[ERROR] : 1~45 사이의 값을 입력해주세요");
    }
}
