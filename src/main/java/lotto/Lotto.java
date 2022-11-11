package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MAX_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateOverlap(numbers);
        sortByAscending(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void sortByAscending(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
