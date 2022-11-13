package lotto;

public enum LottoRank {
    RANK5(3, 5000),
    RANK4(4, 50000),
    RANK3(5, 1500000),
    RANK2(5, 30000000),
    RANK1(6, 2000000000);

    private final int matchingCount;
    private final int prizeMoney;

    LottoRank(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }
}
