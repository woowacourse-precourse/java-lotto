package lotto;

public enum LottoRank {
    FIRST("6개 일치", 1,2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 2,30000000),
    THIRD("5개 일치", 3,1500000),
    FOURTH("4개 일치", 4,50000),
    FIFTH("3개 일치", 5,5000),
    ZERO("0개 일치", 0,0);

    private final String countWriting;
    private final int rank;
    private final int prize;

    LottoRank(String countWriting, int rank, int prize){
        this.countWriting = countWriting;
        this.rank = rank;
        this.prize = prize;
    }

    public String getCountWriting() {
        return countWriting;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}
