package lotto.domain;

public enum MatchCount {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_AND_BONUS_MATCHES(5, 30000000),
    SIX_MATCHES(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    MatchCount(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
