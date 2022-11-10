package lotto.constant;

public enum MatchType {
    THREE_MATCHES("3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCHES("4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCHES_WITHOUT_BONUS("5개 일치 (1,500,000원) - %d개\n"),
    FIVE_MATCHES_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    MatchType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
