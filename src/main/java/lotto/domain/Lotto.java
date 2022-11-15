package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("");
            }
        }
    }

    private void validateUnduplicate(List<Integer> numbers) {
        Set<Integer> unduplicatedNumbers = new HashSet<>(numbers);

        if (unduplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
