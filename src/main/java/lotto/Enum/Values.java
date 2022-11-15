package lotto.Enum;

public enum Values {
    MIN_VALUE(1),
    MAX_VALUE(45),
    COUNT(6),
    LOTTO_AMOUNT(1000);
    private int value;
    Values(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
