package lotto.enums;

public enum LottoRanking {
    FIRST_PLACE(2_000_000_000L, "6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND_PLACE(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD_PLACE(1_500_000L, "5개 일치 (1,500,000원) - %d개\n"),
    FOURTH_PLACE(50_000L, "4개 일치 (50,000원) - %d개\n"),
    FIFTH_PLACE(5_000L, "3개 일치 (5,000원) - %d개\n");

    private final long winnings;
    private final String message;

    LottoRanking(long winnings, String message) {
        this.winnings = winnings;
        this.message = message;
    }

    public long getWinnings() {
        return winnings;
    }

    private String getMessage() {
        return message;
    }
}