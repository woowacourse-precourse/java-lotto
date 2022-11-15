package lotto.view;

public enum OutputMessage {
    PURCHASE("\n%d개를 구매했습니다.\n"),
    STATISTICS("\n당첨 통계\n---"),
    RESULT("%d개 일치 (%,d원) - %d개\n"),
    RESULT_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    RESULT_ROT("총 수익률은 %,.1f%%입니다.\n");
    private final String message;
    OutputMessage(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
