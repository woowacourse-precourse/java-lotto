package lotto.constant;

public enum PercentageConstant {

    PERCENTAGE(100),
    ;

    private final int value;

    PercentageConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
