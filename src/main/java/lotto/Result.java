package lotto;

public enum Result {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000);

    final private int value;

    private Result(int value) {
        this.value = value;
    }

    public int get_value() {
        return value;
    }
}
