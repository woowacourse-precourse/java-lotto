package lotto.Enum;

public enum Number {
    MIN(1),
    MAX(45),
    SIZE(6),
    UNIT(1000),
    ;

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
