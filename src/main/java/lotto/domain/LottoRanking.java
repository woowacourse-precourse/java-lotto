package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2_000_000_000),
    SECOND(5.5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private double lottoScore;
    private int reward;

    LottoRanking(double lottoScore, int reward) {
        this.lottoScore = lottoScore;
        this.reward = reward;
    }

    public double getLottoScore() {
        return lottoScore;
    }

    public int getReward() {
        return reward;
    }

    public static LottoRanking getRanking(double sameNumberCount) {
        return Arrays.stream(LottoRanking.values())
                .filter(result -> result.lottoScore == sameNumberCount)
                .findAny()
                .orElse(LottoRanking.MISS);
    }

    public static double getLottoScoreBy(LottoRanking lottoRanking) {
        return lottoRanking.getLottoScore();
    }
}
