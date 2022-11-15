package lotto;

public enum LottoWinningEnum { // WinningStatistics-print-001
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int correctNumber;
    private final boolean hitBonus;
    private final int money;

    LottoWinningEnum(int correctNumber, boolean hitBonus, int money) {
        this.correctNumber = correctNumber;
        this.hitBonus = hitBonus;
        this.money = money;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public boolean isHitBonus() {
        return hitBonus;
    }

    public int getMoney() {
        return money;
    }
}
