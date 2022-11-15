package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private int matchCount;
    private boolean isMatchBonusNumber;
    private int reward;

    LottoPrize(int matchCount, boolean isMatchBonusNumber, int reward) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public int getSum(int count) {
        return reward * count;
    }

    public static LottoPrize getPrize(int matchCount, boolean isMatchBonusNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == matchCount && prize.isMatchBonusNumber == isMatchBonusNumber)
                .findAny()
                .orElse(NONE);
    }
}
