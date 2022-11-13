package lotto.constant;

public enum LottoConstants {
    LOTTO_START_INCLUSIVE(1),
    LOTTO_END_INCLUSIVE(45);

    private final int value;

    LottoConstants(int value) {
        this.value=value;
    }

    public int value() {
        return this.value;
    }
}
