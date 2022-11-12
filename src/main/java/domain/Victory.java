package domain;

public enum Victory {
    MATCH3(5000,3,false),
    MATCH4(50000,4,false),
    MATCH5(1500000,5,false),
    MATCH_BONUS(30000000,6,true),
    MATCH_ALL(2000000000,6,false);

    private final int winningMoney;
    private final int matchCount;
    private final boolean isBonus;

    Victory(int winningMoney, int matchCount, boolean isBonus) {
        this.winningMoney = winningMoney;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }
}
