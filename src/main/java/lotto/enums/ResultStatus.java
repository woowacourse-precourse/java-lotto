package lotto.enums;

public enum ResultStatus {
    MATCH6(6, 2000000000),
    MATCH5_WITH_BONUS_BALL(5, 30000000, true),
    MATCH5(5, 1500000),
    MATCH4(4, 50000),
    MATCH3(3, 5000),
    NONE(0, 0);

    private final int count;
    private final int value;
    private final boolean hasBonusBall;

    ResultStatus(int count, int value) {
        this.count = count;
        this.value = value;
        this.hasBonusBall = false;
    }

    ResultStatus(int count, int value, boolean hasBonusBall) {
        this.count = count;
        this.value = value;
        this.hasBonusBall = hasBonusBall;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public boolean isHasBonusBall() {
        return hasBonusBall;
    }
}
