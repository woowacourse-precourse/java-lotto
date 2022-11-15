package lotto.model;

public enum Grade {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FORTH_PRIZE(50000),
    FIFTH_PRIZE(5000),
    NOTHING(0);

    private final int reward;

    Grade(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
