package lotto;

public enum Rank {
    FIRST(0), SECOND(1), THIRD(2), FOURTH(3), FIFTH(4), NONE(5);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
