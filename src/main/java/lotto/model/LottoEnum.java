package lotto.model;

public enum LottoEnum {
    MIN_TOTAL_LOTTERIES(1),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    TOTAL_LOTTO_NUMBER(6);

    private final int value;

    LottoEnum(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
