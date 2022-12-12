package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.ErrorMessages.*;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OVER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> number = new HashSet<>(numbers);
        if (number.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATED);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE);
        }
    }

    public boolean contain(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
