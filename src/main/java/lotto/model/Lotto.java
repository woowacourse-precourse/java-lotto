package lotto.model;

import lotto.Util;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!Util.isCorrectSize(numbers, SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
