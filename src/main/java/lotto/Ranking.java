package lotto;

public enum Ranking {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int numberCount;
    private final int prizeMoney;

    Ranking(int numberCount, int prizeMoney) {
        this.numberCount = numberCount;
        this.prizeMoney = prizeMoney;

    }

    public int getNumberCount() {
        return numberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
