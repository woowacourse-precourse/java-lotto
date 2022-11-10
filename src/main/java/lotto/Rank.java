package lotto;

public enum Rank {
    FIRST(5000), SECOND(50000), THIRD(1500000),
    FORTH(2000000000), FIFTH(30000000);
    Rank(int reward) {
        this.reward = reward;
    }
    private final int reward;

    public int getReward() {
        return reward;
    }
}
