package lotto.constant;

public enum IntConstant {
    LOTTO_MONEY_PER_ONE(1000),
    ZERO_ASCII_CODE('0'),
    NINE_ASCII_CODE('9');

    private final int value;

    IntConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
