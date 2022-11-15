package lotto.exception.ticketCount;

public class CountLessZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE =
            "로또티켓 수는 1 이상이어야 합니다. : 자동티켓 %d개, 수동티켓 %d개";

    public CountLessZeroException(final int manualCount, final int autoCount) {
        super(String.format(ERROR_MESSAGE, manualCount, autoCount));
    }
}
