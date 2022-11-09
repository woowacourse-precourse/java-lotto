package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersSizeNotSix(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumbersSizeNotSix(List<Integer> numbers) {
        return numbers.size() != 6;
    }
}
