package lotto;


public enum Reward {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int count;
    private final int reward;

    Reward(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }
}

