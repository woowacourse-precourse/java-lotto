package lotto.constant;

public enum RankInfo {
    FIRST(1, 6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(2, 5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(3, 5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 4, false, 50000, "4개 일치 (50,000원) - "),
    FIFTH(5, 3, false, 5000, "3개 일치 (5,000원) - ");

    private final int rank;
    private final int correct;
    private final boolean bonus;
    private final long reward;
    private final String statement;

    RankInfo(int rank, int correct, boolean bonus, long reward, String statement) {
        this.rank = rank;
        this.correct = correct;
        this.bonus = bonus;
        this.reward = reward;
        this.statement = statement;
    }

    public int getRank() {
        return rank;
    }

    public int getCorrect() {
        return correct;
    }

    public boolean isBonus() {
        return bonus;
    }

    public long getReward() {
        return reward;
    }

    public String getStatement() {
        return statement;
    }
}
