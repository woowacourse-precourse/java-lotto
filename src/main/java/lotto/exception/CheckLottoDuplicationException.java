package lotto.exception;

public class CheckLottoDuplicationException extends IllegalArgumentException {
    public CheckLottoDuplicationException() {
        super("[ERROR] : 로또번호는 중복되지 않아야 합니다.");
    }
}
