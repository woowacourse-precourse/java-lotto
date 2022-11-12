package lotto;

public enum LottoValues {
    LOTTO_AMOUNT(1_000),
    START_LOTTO_VALUE(1),
    MAX_LOTTO_VALUE(45);

    private int value;

    LottoValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
