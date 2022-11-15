package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NOTHING(0, 0, false);

    private final int count;
    private final int reward;
    private final boolean isBonus;

    Rank(int count, int reward, boolean isBonus) {
        this.count = count;
        this.reward = reward;
        this.isBonus = isBonus;
    }

    public static Rank findRank(int count, boolean isBonus) {
        if (isBonus && count == SECOND.count) {
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank != Rank.SECOND)
                .filter(rank -> rank.count == count)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }
}
