package lotto.domain;

import static lotto.domain.Constants.MAX_NUMBER;
import static lotto.domain.Constants.MIN_NUMBER;

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
        validateOverSize(numbers);
        validateDuplicate(numbers);
        validateNumber(numbers);
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numbersToSet = new HashSet<>(numbers);

        if (numbersToSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }
}
