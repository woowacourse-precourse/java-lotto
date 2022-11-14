package lotto.domain;

public enum RankingType {
    FIRST("1등", 6, false, 2000000000),
    SECOND("2등", 5, true, 30000000),
    THIRD("3등", 5, false, 1500000),
    FOURTH("4등", 4, false, 50000),
    FIFTH("5등", 3, false, 5000),
    DROP_OUT("탈락", 0, false, 0);

    private final String korean;
    private final int condition;
    private final boolean isNeedBonus;
    private final int prizeMoney;

    RankingType(String korean, int condition, boolean isNeedBonus, int prizeMoney) {
        this.korean = korean;
        this.condition = condition;
        this.isNeedBonus = isNeedBonus;
        this.prizeMoney = prizeMoney;
    }

    public String getKorean() {
        return korean;
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
