package lotto.exception;

public class CheckThisNumException extends NumberFormatException {
    public CheckThisNumException() {
        super("[ERROR] : 숫자를 입력해 주세요");
    }
}
