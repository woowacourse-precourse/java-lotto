package lotto.entity;

public enum Place {
    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000);
    private final String rank;
    private final long prizeMoney;

    private Place(String rank, long prizeMoney) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public String getRank() {
        return this.rank;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }
}
