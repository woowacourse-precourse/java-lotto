package lotto.type;

import lotto.model.Score;

public enum PrizeType {
    FIRST_PRIZE(Score.of(6, 0), 2_000_000_000),
    SECOND_PRIZE(Score.of(5, 1), 30_000_000),
    THIRD_PRIZE(Score.of(5, 0), 1_500_000),
    FOURTH_PRIZE(Score.of(4, 0), 50_000),
    FIFTH_PRIZE(Score.of(3, 0), 5_000),
    NOTHING(Score.of(0, 0), 0);

    private final Score condition;
    private final int reward;

    PrizeType(Score condition, int reward) {
        this.condition = condition;
        this.reward = reward;
    }

    public Score getCondition() {
        return this.condition;
    }

    public int getReward() {
        return this.reward;
    }
}
