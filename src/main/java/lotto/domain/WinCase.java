package lotto.domain;

public enum WinCase {
    FAIL(0, false, 0),
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_WITH_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int equalCount;
    private final boolean isBonus;
    private final int cashPrize;

    WinCase(int equalCount, boolean isBonus, int cashPrize) {
        this.equalCount = equalCount;
        this.isBonus = isBonus;
        this.cashPrize = cashPrize;
    }

    public static WinCase getEqualCount(int equalCount, boolean isBonus){
        if (equalCount == 3) return THREE;
        if (equalCount == 4) return FOUR;
        if (equalCount == 5 && !isBonus) return FIVE;
        if (equalCount == 5 && isBonus) return FIVE_WITH_BONUS;
        if (equalCount == 6) return SIX;
        return FAIL;
    }

    public int getEqualCount(){
        return this.equalCount;
    }

    public boolean getIsBonus(){
        return this.isBonus;
    }

    public int getCashPrize(){
        return this.cashPrize;
    }
}