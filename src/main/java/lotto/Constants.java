package lotto;

import java.util.List;

public enum Constants {
    NUMBERS_LENGTH(6),
    MIN_NUMBER_RANGE(1),
    MAX_NUMBER_RANGE(45);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
