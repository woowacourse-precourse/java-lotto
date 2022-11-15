package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (!DomainValidator.hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getErrorMessage());
        }

        for (int number : numbers) {
            if (!DomainValidator.hasCorrectRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
            }
        }

        if (!DomainValidator.isAllUnique(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getErrorMessage());
        }
    }



    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
