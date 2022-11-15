package lotto.constant;

public enum Constant {
    LOTTO_LENGTH(6),
    LOTTO_MIN_VALUE(1),
    LOTTO_MAX_VALUE(45),
    UNIT_PRICE(1000);

    final private int value;

    private Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
