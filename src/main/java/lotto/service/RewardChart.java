package lotto.service;

public enum RewardChart {
    FIRST_REWARD(2_000_000_000),
    SECOND_REWARD(30_000_000),
    THIRD_REWARD(1_500_000),
    FOURTH_REWARD(50_000),
    FIFTH_REWARD(5_000);

    private final int value;

    RewardChart(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
