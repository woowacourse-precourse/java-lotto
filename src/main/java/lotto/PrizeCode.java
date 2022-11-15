package lotto;

public enum PrizeCode {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NONE(-1, 0);

    private final int rank;
    private final int reward;

    PrizeCode(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }
}
