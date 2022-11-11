package lotto;

public enum Rank {
    FIRST(0, "6개 일치 (2,000,000,000원) - "),
    SECOND(1, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(2, "5개 일치 (1,500,000원) - "),
    FORTH(3, "4개 일치 (50,000원) - "),
    FIFTH(4, "3개 일치 (5,000원) - ");

    private final int rank;
    private final String info;

    Rank(int rank, String info) {
        this.rank = rank;
        this.info = info;
    }

    public int getRank() {
        return this.rank;
    }
    public String getInfo() { return this.info; }

}
