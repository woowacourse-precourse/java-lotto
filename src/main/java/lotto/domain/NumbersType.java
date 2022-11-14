package lotto.domain;

public enum NumbersType {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    NUMBERS_SIZE(6);

    private final int value;

    NumbersType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}