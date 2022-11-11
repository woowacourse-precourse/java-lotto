package lotto.constant;

public enum IntConstant {
    LOTTO_MONEY_PER_ONE(1000),
    ZERO_ASCII_CODE('0'),
    NINE_ASCII_CODE('9'),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_NUMBER_BIGGER_THAN(1),
    LOTTO_NUMBER_SMALLER_THAN(45),
    BONUS_LOTTO_NUMBER_COUNT(1);

    private final int value;

    IntConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
