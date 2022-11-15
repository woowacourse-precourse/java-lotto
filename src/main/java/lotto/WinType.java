package lotto;

public enum WinType {
    SIX(2000000000),
    FIVE_BONUS(30000000),
    FIVE(1500000),
    FOUR(50000),
    THREE(5000),
    NONE(0);

    private final int value;
    private WinType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
