package lotto.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public enum Rank {
    NONE(0, "0"),
    FIFTH(3, "5,000"),
    FOURTH(4, "50,000"),
    THIRD(5, "1,500,000"),
    SECOND(5, "30,000,000"),
    FIRST(6, "2,000,000,000");

    private final Integer matchNumber;
    private final String reward;

    Rank(Integer matchNumber, String reward) {
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

    public String getReward() {
        return reward;
    }
}
