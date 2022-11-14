package lotto;

import java.util.List;

public class Lotto {
    private static final int SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInValidSize(numbers) || hasOutOfBoundNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInValidSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    private static boolean hasOutOfBoundNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(x -> x < START_NUMBER || x > END_NUMBER);
    }
}
