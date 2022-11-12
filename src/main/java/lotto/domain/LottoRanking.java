package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2_000_000_000),
    SECOND(5.5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private double sameNumber;
    private int reward;

    LottoRanking(double sameNumber, int reward) {
        this.sameNumber = sameNumber;
        this.reward = reward;
    }

    public double getSameNumber() {
        return sameNumber;
    }

    public int getReward() {
        return reward;
    }

    public static LottoRanking getResult(double sameNumberCount) {
        return Arrays.stream(LottoRanking.values())
                .filter(result -> result.sameNumber == sameNumberCount)
                .findAny()
                .orElse(LottoRanking.MISS);
    }
}
