package lotto;

public enum Score {
    FIRST(1,2000000000,"6개 일치 (2,000,000,000원) - "),
    SECOND(2,30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(3,1500000,"5개 일치 (1,500,000원) - "),
    FOURTH(4,50000,"4개 일치 (50,000원) - "),
    FIFTH(5,5000,"3개 일치 (5,000원) - "),
    NOTHING(6,0,"당첨되지 않음");


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
