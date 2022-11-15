package lotto;

public enum RewardType {

    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_WITH_BONUS(30_000_000),
    SIX(2_000_000_000);

    private int reward;

    RewardType(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }
}
