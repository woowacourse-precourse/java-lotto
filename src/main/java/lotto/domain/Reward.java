package lotto.domain;

public enum Reward {
    FIFTH_REWARD("3개 일치 (5,000원)", 5000),
    FOURTH_REWARD("4개 일치 (50,000원)", 50000),
    THIRD_REWARD("5개 일치 (1,500,000원)", 1500000),
    SECOND_REWARD("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST_REWARD("6개 일치 (2,000,000,000원)", 2000000000);

    private final String message;
    private final int reward;

    Reward(String message, int reward) {
        this.message = message;
        this.reward = reward;
    }

    public String getMessage() {
        return message;
    }

    public int getReward() {
        return reward;
    }
}
