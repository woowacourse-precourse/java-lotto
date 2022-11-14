package lotto.util;

public enum CONSTANTS {
    MINIMUM(1),
    MAXIMUM(45),
    LOTTO_COUNT(6);

    private int numbers;

    CONSTANTS(int count) {
        this.numbers = count;
    }

    public int getNumbers() {
        return numbers;
    }
}
