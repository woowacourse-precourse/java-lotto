package lotto.Model;

public enum ValidNumbers {
    MIN_LOTTO_RANGE(1), MAX_LOTTO_RANGE(45), MIN_COST(1_000), MAX_LOTTO_SIZE(6);

    private final int value;

    ValidNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
