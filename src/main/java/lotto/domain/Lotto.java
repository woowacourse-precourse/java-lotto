package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_OVER_SIZE);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> number = new HashSet<>(numbers);
        if (number.size() != 6) {
            throw new IllegalArgumentException(ERROR_DUPLICATED);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_OVER_RANGE);
        }
    }
}
