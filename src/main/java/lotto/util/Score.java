package lotto.util;

public enum Score {
    ZERO(0),
    ONE(0),
    TWO(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000);
    private final int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
