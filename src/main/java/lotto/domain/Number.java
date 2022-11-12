package lotto.domain;

public enum Number {
    LOTTO(6), BONUS(1),
    START_RANGE(1), END_RANGE(45);
    private final int size;

    Number(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }
}
