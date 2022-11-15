package lotto;

public enum PrizeMoney {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int countEqual;
    private final Boolean isBonusNumberEqual;
    private final int prizeMoney;

    PrizeMoney(int countEqual, Boolean isBonusNumberEqual, int prizeMoney) {
        this.countEqual = countEqual;
        this.isBonusNumberEqual = isBonusNumberEqual;
        this.prizeMoney = prizeMoney;
    }

    public int getCountEqual() {
        return countEqual;
    }

    public Boolean getBonusNumberEqual() {
        return isBonusNumberEqual;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
