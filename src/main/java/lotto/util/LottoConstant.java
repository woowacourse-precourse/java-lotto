package lotto.util;

public enum LottoConstant {
    NUMBER_COUNT(6),
    START_NUMBER(1),
    END_NUMBER(45),
    PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
