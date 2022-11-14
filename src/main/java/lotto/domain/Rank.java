package lotto.domain;

public enum Rank {
    FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
