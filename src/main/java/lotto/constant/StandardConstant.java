package lotto.constant;

public enum StandardConstant {

    MONEY_UNIT_STANDARD(1_000),
    LOTTO_NUMBERS_COUNT_STANDARD(6),
    ;

    private final int value;

    StandardConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
