package lotto;

public enum LottoSetting {
    PRICE(1_000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COUNT(6);

    private final int value;

    LottoSetting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

