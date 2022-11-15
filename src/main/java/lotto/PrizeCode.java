package lotto;

public enum PrizeCode {
    FIRST(1, 2000000000, "6개 일치"),
    SECOND(2, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(3, 1500000, "5개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    FIFTH(5, 5000, "3개 일치"),
    NONE(-1, 0, "");

    private final int rank;
    private final int reward;
    private final String condition;

    PrizeCode(int rank, int reward, String condition) {
        this.rank = rank;
        this.reward = reward;
        this.condition = condition;
    }

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }

    public String getCondition() {
        return condition;
    }
}
