package domain;

public enum Prize {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    public final int prizeValue;

    Prize(int prizeValue) {
        this.prizeValue = prizeValue;
    }

    public int getPrize() {
        return prizeValue;
    }
}
