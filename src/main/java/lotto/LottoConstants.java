package lotto;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
