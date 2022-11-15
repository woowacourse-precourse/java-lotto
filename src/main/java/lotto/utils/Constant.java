package lotto.utils;

public enum Constant {

    LOTTO_SIZE(6),
    LOTTO_RANGE_START_NUM(1),
    LOTTO_RANGE_END_NUM(45),
    MINIMUM_AMOUNT(1000),
    CURRENCY_UNIT(1000);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
