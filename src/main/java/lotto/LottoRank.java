package lotto;

public enum LottoRank {
    FRIST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THRID(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private int rankNum;
    private int price;

    LottoRank(int rankNum, int price) {
        this.rankNum = rankNum;
        this.price = price;
    }
}
