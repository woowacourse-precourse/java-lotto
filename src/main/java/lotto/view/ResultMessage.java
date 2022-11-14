package lotto.view;

public enum ResultMessage {
    RESULT("당첨 통계\n---"),
    THREE_HIT("3개 일치 (5,000원) - %d개%n"),
    FOUR_HIT("4개 일치 (50,000원) - %d개%n"),
    FIVE_HIT("5개 일치 (1,500,000원) - %d개%n"),
    FIVE_HIT_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    SIX_HIT("6개 일치 (2,000,000,000원) - %d개%n"),
    RATE_PROFIT("총 수익률은 %.1f%%입니다.%n");

    private final String message;

    ResultMessage(String message) { this.message = message; }
    public String getMessage() { return this.message; }
}
