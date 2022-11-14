package ui;

public enum PrintMessage {
    PURCHASE_INFO("개를 구매했습니다."),
    STATISTIC_INFO("당첨 통계"),
    TOTAL_PRIZE("총 수익률은 ");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
