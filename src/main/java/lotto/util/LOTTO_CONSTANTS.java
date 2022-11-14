package lotto.util;

public enum LOTTO_CONSTANTS {
    MINIMUM(1),
    MAXIMUM(45),
    LOTTO_COUNT(6);

    private int numbers;

    LOTTO_CONSTANTS(int count) {
        this.numbers = count;
    }

    public int getNumbers() {
        return numbers;
    }
}
