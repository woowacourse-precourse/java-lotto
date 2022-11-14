package lotto;

import java.util.List;

public class Lotto {
    private static final int SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInValidSize(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInValidSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }
}
