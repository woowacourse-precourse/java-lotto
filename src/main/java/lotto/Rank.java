package lotto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank getRank(int matchCount,final boolean equalBonus) {
        if (matchCount==5 && equalBonus) {
            return SECOND;
        }

        if (matchCount < FIFTH.matchCount) {
            return NONE;
        }

        return Arrays.stream(values()).filter((rank -> rank.matchCount == matchCount)).findAny().orElseThrow(NoSuchElementException::new);

    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

}
