package lotto.exception;

public class CheckMoneyCountException extends IllegalArgumentException {
    public CheckMoneyCountException() {
        super("[ERROR] : 1000원 단위의 숫자를 입력해 주세요");
    }
}
