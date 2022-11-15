package lotto.util;

public enum Type {
    LOTTO(1),
    BONUS(2),
    AMOUNT(3);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
