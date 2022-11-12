package lotto;

public enum Rank {
    FIRST(2000000000), SECOND(30000000), THIRD(1500000),
    FORTH(50000), FIFTH(5000);
    Rank(int reward) {
        this.reward = reward;
    }
    private final int reward;

    public int getReward() {
        return reward;
    }
}
