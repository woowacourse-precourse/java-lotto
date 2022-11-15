package data;

public enum PrizeData {
    FIFTH(5000, 3, false),
    FOURTH(50000, 4, false),
    THIRD(1500000, 5, false),
    SECOND(30000000, 5, true),
    FIRST(2000000000, 6, false);

    private final int prizeMoney;
    private final int winningCount;
    private final boolean isHavingBonus;

    PrizeData(int prizeMoney, int winningCount, boolean isHavingBonus){
        this.prizeMoney = prizeMoney;
        this.winningCount = winningCount;
        this.isHavingBonus = isHavingBonus;
    }
}
