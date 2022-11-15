package lotto.domain;

public enum LottoConstants {
    LOTTO_PRICE(1000),
    LOTTO_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    MIN_WINNING_COUNT(3);

    private final int value;
    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
