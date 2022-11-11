package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplicate(numbers);
        validateSize(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberStorage = new HashSet<>(numbers);
        if (numberStorage.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
