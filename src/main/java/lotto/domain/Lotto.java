package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.ErrorMessages.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OVER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> number = new HashSet<>(numbers);
        if (number.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATED);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
