package lotto.data.type;

public enum LottoNumberType {
    COST(1000),
    COUNT(6),
    MIN(1),
    MAX(45);

    private final int value;

    LottoNumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
