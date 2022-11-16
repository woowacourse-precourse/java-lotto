package lotto;

public enum Result {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOLUCK(0, 0);

    private int numOfMatch;
    private int reward;

    Result(int numOfMatch, int reward) {
        this.numOfMatch = numOfMatch;
        this.reward = reward;
    }

    public int getNumOfMatch() {
        return this.numOfMatch;
    }

    public int getReward() {
        return this.reward;
    }

}
