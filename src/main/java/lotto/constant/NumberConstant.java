package lotto.constant;

public enum NumberConstant {

    ZERO(0),
    ;

    private final int value;

    NumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
