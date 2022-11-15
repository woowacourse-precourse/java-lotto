package lotto.model.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5.5),
    FIRST(2_000_000_000, 6);

    private final int reward;
    private final double numOfMatch;

    Rank(int reward, double numOfMatch) {
        this.reward = reward;
        this.numOfMatch = numOfMatch;
    }

    static Rank create(double numOfMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.numOfMatch == numOfMatch)
                .findAny()
                .orElse(NOTHING);
    }

    int getReward() {
        return reward;
    }
}
