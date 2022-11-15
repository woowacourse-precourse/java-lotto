package lotto.value;

public enum LottoValue {
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),
    LOTTO_SIZE(6);
    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
