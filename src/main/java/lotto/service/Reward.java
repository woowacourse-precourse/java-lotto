package lotto.service;

public enum Reward {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000);

    private final double rewardPrice;

    Reward(double rewardPrice) {
        this.rewardPrice = rewardPrice;
    }

    public double getRewardPrice() {
        return rewardPrice;
    }
}
