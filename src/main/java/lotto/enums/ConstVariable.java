package lotto.enums;

public enum ConstVariable {
    MIN_NUMBER(1), MAX_NUMBER(45), LOTTO_COUNT(6), STANDARD(1000);

    private final int value;

    ConstVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
