package lotto;

public enum Message {
    ILLEGAL_ARGUMENT_ERROR_MESSAGE("[ERROR] Illegal Argument"),
    HOW_MANY_BUY_STRING("개를 구매했습니다." + System.lineSeparator()),
    WINNING_STATISTICS_START_MESSAGE("당첨 통계" + System.lineSeparator() + "---" + System.lineSeparator()),
    WINNING_YIELD_PRINT_FORM("총 수익률은 %yield%입니다." + System.lineSeparator());

    private final String  message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
