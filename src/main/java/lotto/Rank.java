package lotto;

public enum Rank {
    THREE(3, 5000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L),
    BONUS(5, 30_000_000L),
    SIX(6, 2_000_000_000L);

    private final int matchingCount;
    private final long prize;

    Rank(int matchingCount, long prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrize() {
        return prize;
    }
}
