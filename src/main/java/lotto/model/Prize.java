package lotto.model;

public enum Prize {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingCount;
    private final long reward;

    Prize(int matchingCount, long reward) {
        this.matchingCount = matchingCount;
        this.reward = reward;
    }

    public long getMatchingCount() {
        return this.matchingCount;
    }

    public long getReward() {
        return this.reward;
    }
}
