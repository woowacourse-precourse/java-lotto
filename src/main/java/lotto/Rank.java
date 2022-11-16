package lotto;

public enum Rank {
    FIRST(1, "6개 일치",2_000_000_000),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD(3, "5개 일치", 1_500_000),
    FOURTH(4, "4개 일치", 50_000),
    FIFTH(5, "3개 일치", 5_000);

    private final int rankNum;
    private final String ballCount;
    private final int prizeMoney;

    Rank(int rankNum, String ballCount, int prizeMoney) {
        this.rankNum = rankNum;
        this.ballCount = ballCount;
        this.prizeMoney = prizeMoney;
    }
    public int rankNum() {
        return rankNum;
    }
    public String ballCount() {
        return ballCount;
    }
    public int prizeMoney() {
        return prizeMoney;
    }
}