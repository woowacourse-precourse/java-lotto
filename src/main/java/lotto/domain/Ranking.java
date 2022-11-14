package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIFTH_PLACE(5_000, 3),
    FOURTH_PLACE(50_000, 4),
    THIRD_PLACE(1_500_000, 5),
    SECOND_PLACE(30_000_000, 5),
    FIRST_PLACE(2_000_000_000, 6),
    NOT_RANKED(0, 0);

    private final int reward;
    private final int numberOfMatchNumbers;

    Ranking(int reward, int numberOfMatchNumbers) {
        this.reward = reward;
        this.numberOfMatchNumbers = numberOfMatchNumbers;
    }

    public static Ranking getRank(int numberOfMatchNumbers, boolean bonusNumberMatch) {
        if (numberOfMatchNumbers == THIRD_PLACE.numberOfMatchNumbers) {
            return checkSecondOrThird(bonusNumberMatch);
        }

        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.numberOfMatchNumbers == numberOfMatchNumbers)
                .findAny()
                .orElse(NOT_RANKED);
    }

    private static Ranking checkSecondOrThird(boolean bonusNumberMatch) {
        if (bonusNumberMatch) {
            return SECOND_PLACE;
        }
        return THIRD_PLACE;
    }


    public int getReward() {
        return reward;
    }

    public int getNumberOfMatchNumbers() {
        return numberOfMatchNumbers;
    }
}
