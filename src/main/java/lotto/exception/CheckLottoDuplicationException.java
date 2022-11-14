package lotto.exception;

public class CheckLottoDuplicationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또번호는 중복되지 않아야 합니다.";

    public CheckLottoDuplicationException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
