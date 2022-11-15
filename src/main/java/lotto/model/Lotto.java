package lotto.model;

import lotto.model.enumeration.Exception;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Exception.INVALID_LOTTO_NUMBER_RANGE.getExceptionMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> subNumbers = numbers.subList(i+1, numbers.size());
            int number = numbers.get(i);
            if (subNumbers.contains(number)) {
                throw new IllegalArgumentException(Exception.INVALID_LOTTO_NUMBER_DUPLICATION.getExceptionMessage());
            }
        }
    }
}
