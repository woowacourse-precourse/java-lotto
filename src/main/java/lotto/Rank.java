package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NO_RANK(0, false, 0);

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int reward;

    Rank(int matchCount, boolean isBonusMatch, int reward) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public int getReward() {
        return reward;
    }

    public static Rank of(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.isBonusMatch() == isBonusMatch)
                .findFirst()
                .orElse(NO_RANK);
    }
}