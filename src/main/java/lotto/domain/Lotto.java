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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public int compare(List<Integer> lotto) {
        return (int) numbers.stream()
                .filter(number -> lotto.stream()
                .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
