package lotto.domain;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    ETC(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final long reward;

    Rank(int matchCount, boolean matchBonus, long reward) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public long getReward() {
        return reward;
    }
}
