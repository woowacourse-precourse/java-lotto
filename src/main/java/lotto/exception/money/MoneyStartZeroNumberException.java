package lotto.exception.money;

public class MoneyStartZeroNumberException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_START_ZERO = "[ERROR] 0으로 시작하는 돈은 없습니다. ex)001000";

    public MoneyStartZeroNumberException() {
        super(EXCEPTION_MESSAGE_START_ZERO);
    }
}
