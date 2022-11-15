package lotto.util;

public enum CONSTANTS {
    MINIMUM(1),
    MAXIMUM(45),
    LOTTO_COUNT(6),
    MONETARY_UNIT(1000),
    RANK(8),
    FIRST_POSITION(6),
    SECOND_POSITION(5),
    THIRD_POSITION(4),
    FOURTH_POSITION(3),
    BONUS_POSITION(7);

    private int numbers;

    CONSTANTS(int count) {
        this.numbers = count;
    }

    public int getNumbers() {
        return numbers;
    }
}
