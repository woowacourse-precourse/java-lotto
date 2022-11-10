package lotto;

public enum LottoNumberRange {
    MIN(1),
    MAX(45);

    private final int value;

    LottoNumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
