package lotto.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final Integer matchNumber;
    private final Integer reward;

    Rank(Integer matchNumber, Integer reward) {
        this.matchNumber = matchNumber;
        this.reward = reward;
    }

    public static Rank findRank(int matchNum, boolean bonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchNumber().equals(matchNum))
                .map(discriminateSecond(bonusNumber))
                .findFirst()
                .orElse(NONE);
    }

    private static Function<Rank, Rank> discriminateSecond(boolean bonusNumber) {
        return rank -> {
            if (Objects.equals(rank.matchNumber, SECOND.getMatchNumber()) && bonusNumber) {
                return SECOND;
            }
            return rank;
        };
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public Integer getReward() {
        return reward;
    }
}
