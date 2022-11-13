package lotto.utils;

public enum LottoRanking {
    FIFTH_PLACE(3, 5_000L, "3개 일치 (5,000원) - %d개\n", false),
    FOURTH_PLACE(4, 50_000L, "4개 일치 (50,000원) - %d개\n", false),
    THIRD_PLACE(5, 1_500_000L, "5개 일치 (1,500,000원) - %d개\n", false),
    SECOND_PLACE(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", true),
    FIRST_PLACE(6, 2_000_000_000L, "6개 일치 (2,000,000,000원) - %d개\n", false);

    private final int matchCount;
    private final long winnings;
    private final String message;
    private final boolean bonus;

    LottoRanking(int matchCount, long winnings, String message, boolean bonus) {
        this.matchCount = matchCount;
        this.winnings = winnings;
        this.message = message;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinnings() {
        return winnings;
    }

    public String getMessage() {
        return message;
    }

    public boolean getBonus() {
        return bonus;
    }
}