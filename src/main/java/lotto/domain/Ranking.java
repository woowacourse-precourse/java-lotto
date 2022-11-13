package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000),
    NOT_RANKED(0, false, 0);

    private final int matchNumbers;
    private final boolean bonusNumber;
    private final int reward;

    Ranking(int matchNumbers, boolean bonusNumber, int reward) {
        this.matchNumbers = matchNumbers;
        this.bonusNumber = bonusNumber;
        this.reward = reward;
    }

    public static Ranking getRank(int numberOfMatchNumbers, boolean bonusNumberMatch) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchNumbers == numberOfMatchNumbers && ranking.bonusNumber == bonusNumberMatch)
                .findAny()
                .orElse(NOT_RANKED);
    }

    public int getReward() {
        return reward;
    }
}
