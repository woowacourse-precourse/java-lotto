package lotto.constant;

public enum Information {
    PRINT_AMOUNT_OF_LOTTO("\n%d개를 구매했습니다."),
    WINNING_STATISTICS("\n당첨 통계\n---\n"),
    YIELD("총 수익률은 %.2f%입니다");

    private final String message;

    Information(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
