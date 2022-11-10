package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    public int getNumberAt(int at) {
        return numbers.get(at);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        int beforeSize = numbers.size();
        long afterDistinctSize = numbers.stream().distinct().count();

        if (beforeSize != afterDistinctSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (isGreaterThanRange(numbers)
                || isLessThanRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isGreaterThanRange(List<Integer> numbers) {
        long greaterThanRangeCount = numbers.stream()
                .filter(n -> n > 45)
                .count();
        return greaterThanRangeCount != 0;
    }

    private boolean isLessThanRange(List<Integer> numbers) {
        long greaterThanRangeCount = numbers.stream()
                .filter(n -> n < 1)
                .count();
        return greaterThanRangeCount != 0;
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
