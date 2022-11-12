package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5.5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private double sameNumber;
    private int reward;

    LottoResult(double sameNumber, int reward) {
        this.sameNumber = sameNumber;
        this.reward = reward;
    }

    public double getSameNumber() {
        return sameNumber;
    }

    public int getReward() {
        return reward;
    }

    public static LottoResult getResult(double sameNumberCount) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.sameNumber == sameNumberCount)
                .findAny()
                .orElse(LottoResult.MISS);
    }
}
