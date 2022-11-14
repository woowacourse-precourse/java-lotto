package lotto.utils.winning;

public enum RewardUtil {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int reward;

    RewardUtil(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }

}
