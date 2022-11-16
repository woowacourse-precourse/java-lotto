package lotto.enums;

public enum LottoInfo {
    START_NUMBER(1),
    END_NUMBER(45),
    NUMBER_COUNT(6),
    PRICE(1_000);

    private final int value;

    LottoInfo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
