package lotto.constant;

import java.text.DecimalFormat;

public enum IntConstant {
    LOTTO_MONEY_PER_ONE(1000),
    ZERO_ASCII_CODE('0'),
    NINE_ASCII_CODE('9'),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_NUMBER_BIGGER_THAN(1),
    LOTTO_NUMBER_SMALLER_THAN(45),
    BONUS_LOTTO_NUMBER_COUNT(1),
    THREE_CORRECT_MONEY(5000),
    FOUR_CORRECT_MONEY(50000),
    FIVE_CORRECT_MONEY(1500000),
    FIVE_CORRECT_BONUS_CORRECT(30000000),
    SIX_CORRECT_MONEY(2000000000);

    private final int value;

    IntConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getMoneyValue() {
        DecimalFormat format = new DecimalFormat("###,###");
        return format.format(this.value);
    }
}
