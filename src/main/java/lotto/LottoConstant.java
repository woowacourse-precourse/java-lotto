package lotto;

public enum LottoConstant {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBERS_SIZE(6),
    PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
