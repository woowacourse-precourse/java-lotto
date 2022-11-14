package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        Set<Integer> overlap = new HashSet<>();
        for (int number : numbers) {
            numberOverlapCheck(overlap, number);
            numberMaxMinCheck(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void numberMaxMinCheck(int number) {
        if (number < RANGE_MIN || number > RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void numberOverlapCheck(Set<Integer> overlap, int number) {
        if (overlap.contains(number)) {
            throw new IllegalArgumentException();
        }
        overlap.add(number);
    }

}
