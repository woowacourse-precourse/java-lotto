package lotto.domain;

import lotto.LottoInputException;

import java.util.Arrays;

public enum Rank {
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

    public static Rank findRank(int matchNum) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchNumber().equals(matchNum))
                .findFirst()
                .orElseThrow();
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public Integer getReward() {
        return reward;
    }
}
