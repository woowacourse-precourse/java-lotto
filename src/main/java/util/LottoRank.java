package util;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSING_TICKET(0, 0);

    private int sameCount;
    private int prizeMoney;

    LottoRank(int sameCount, int prizeMoney) {
        this.sameCount = sameCount;
        this.prizeMoney = prizeMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
