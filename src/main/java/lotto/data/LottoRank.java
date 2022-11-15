package lotto.message;

public enum LottoRank {
    FIFTH(5,"3개 일치 (5,000원) - "),
    FOURTH(4,"4개 일치 (50,000원) - "),
    THIRD(3,"5개 일치 (1,500,000원) - "),
    SECOND(2,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(1, "6개 일치 (2,000,000,000원) - ");

    private int rank;
    private String state;

    LottoRank(int rank, String state) {
        this.rank = rank;
        this.state = state;
    }

    public int getRank() {
        return rank;
    }

    public String getState() {
        return state;
    }
}


