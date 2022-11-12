package domain;

public enum LottoReward {
    REWARD_LOTTO_3(5000),
    REWARD_LOTTO_4(50000),
    REWARD_LOTTO_5(1500000),
    REWARD_LOTTO_5_BONUS(30000000),
    REWARD_LOTTO_6(2000000000);

    private final int reward;
    LottoReward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
