package lotto.domain;

import static lotto.domain.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    static final int MINIMUM_NUMBER = 1;
    static final int MAXIMUM_NUMBER = 45;
    static final int NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberStorage = new HashSet<>(numbers);
        if (numberStorage.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
