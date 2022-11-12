package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.ErrorMessage.*;

public class Lotto {
    static final int MINIMUM_NUMBER = 1;
    static final int MAXIMUM_NUMBER = 45;
    static final int NUMBER_SIZE = 6;

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
            System.out.println(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberStorage = new HashSet<>(numbers);
        if (numberStorage.size() != NUMBER_SIZE) {
            System.out.println(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            System.out.println(LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
