package lotto.domain;

public enum RankingType {
    DROP_OUT(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);


    private final int condition;
    private final boolean isNeedBonus;
    private final int prizeMoney;

    RankingType(int condition, boolean isNeedBonus, int prizeMoney) {
        this.condition = condition;
        this.isNeedBonus = isNeedBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCondition() {
        return condition;
    }

    public boolean isNeedBonus() {
        return isNeedBonus;
    }
}
