package lotto.exception.utils;

public class NotNumberException extends IllegalArgumentException{
    public NotNumberException() {
        super("[ERROR] 숫자만 입력해야 합니다.");
    }
}
