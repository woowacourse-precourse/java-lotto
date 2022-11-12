package lotto;

public enum Score {
    FIRST(1,2000000000,"6개 일치 (2,000,000,000원) - "),
    SECOND(2,2000000000,"6개 일치 (2,000,000,000원) - "),
    THIRD(3,2000000000,"6개 일치 (2,000,000,000원) - "),
    FOURTH(4,2000000000,"6개 일치 (2,000,000,000원) - "),
    FIFTH(5,2000000000,"6개 일치 (2,000,000,000원) - "),
    SIXTH(6,2000000000,"6개 일치 (2,000,000,000원) - "),
    NOTHING(6,2000000000,"6개 일치 (2,000,000,000원) - ");


    private final int rank;
    private final int reward;
    private final String print;

    public int getRank() {
        return rank;
    }

    public int getReward() {
        return reward;
    }

    public String getPrint() {
        return print;
    }

    Score(int rank, int reward, String print) {
        this.rank = rank;
        this.reward = reward;
        this.print = print;
    }
}
