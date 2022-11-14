package lotto.data;

public enum Rank {
    FIFTH(5, "5,000원", "3개 일치"),
    FOURTH(4, "50,000원", "4개 일치"),
    THIRD(3, "1,500,000원", "5개 일치"),
    SECOND(2, "30,000,000원", "5개 일치, 보너스 볼 일치"),
    FIRST(1, "2,000,000,000원", "6개 일치");

    final private int rank;
    final private String prize;
    final private String condition;

    public int getRank() {
        return this.rank;
    }

    public String getPrize() {
        return this.prize;
    }

    public String getCondition() {
        return this.condition;
    }

    Rank(int rank, String prize, String condition) {
        this.rank = rank;
        this.prize = prize;
        this.condition = condition;
    }

}
