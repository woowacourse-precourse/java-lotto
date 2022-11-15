package lotto.domain;

public enum Rank {
    MISS(0, 0, "꽝"),
    THREE(3, 5_000, "3개 일치 (5,000원) - %d개"),
    FOUR(4, 50_000, "4개 일치 (50,000원) - %d개"),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FIVE_WITH_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final int reward;
    private final String winningMessage;

    Rank(final int matchCount, final int reward, final String winningMessage) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.winningMessage = winningMessage;
    }

    public int getReward() {
        return this.reward;
    }
    public String getWinningMessage() {
        return this.winningMessage;
    }

    public static Rank lottoMatchRank(int matchCount, boolean isBonusNumber) {
        if (matchCount == 6) { return SIX; }
        if (matchCount == 5 && isBonusNumber) { return FIVE_WITH_BONUS; }
        if (matchCount == 5) { return FIVE; }
        if (matchCount == 4) { return FOUR; }
        if (matchCount == 3) { return THREE; }
        return MISS;
    }

    @Override
    public String toString() {
        return this.winningMessage;
    }
}
