package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> mutable = new ArrayList<>(numbers);
        validateLength(mutable);
        validateOverlap(mutable);
        sortByAscending(mutable);
        this.numbers = mutable;
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
