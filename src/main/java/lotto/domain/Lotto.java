package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int compare(Lotto another) {
        return another.compareRealValue(this.numbers);
    }

    public int compareRealValue(List<Integer> anotherNumbers) {
        return (int) numbers.stream()
                        .filter(old -> anotherNumbers.stream()
                        .anyMatch(Predicate.isEqual(old)))
                        .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
