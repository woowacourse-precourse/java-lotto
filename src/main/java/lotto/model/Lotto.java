package lotto.model;

import static lotto.enums.PrintMsg.*;
import static lotto.enums.Constant.*;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        validateBetween1And45(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != CORRECT_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_LOTTO_NUMBER_IS_NOT_SIX.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinct_numbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (distinct_numbers.size() != CORRECT_LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_LOTTO_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    private void validateBetween1And45(List<Integer> numbers) {
        List<Integer> filter_numbers = numbers.stream()
                .filter(number -> number < START_NUMBER.getValue() || number > END_NUMBER.getValue())
                .collect(Collectors.toList());
        if (!filter_numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX.getMessage() + ERROR_LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_45.getMessage());
        }
    }
}
