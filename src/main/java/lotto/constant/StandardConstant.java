package lotto.constant;

public enum StandardConstant {

    MONEY_UNIT_STANDARD(1_000),
    ;

    private final int value;

    StandardConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
