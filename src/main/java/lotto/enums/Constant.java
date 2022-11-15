package lotto.enums;

public enum Constant {
    START_NUMBER(1),
    END_NUMBER(45),
    CORRECT_LOTTO_SIZE(6),
    PRICE_OF_LOTTO(1000),
    MATCHING_BONUS_NUMBER(10);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}