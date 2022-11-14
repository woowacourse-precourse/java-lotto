package lotto.domain;

import lotto.domain.constant.LottoProperty;
import lotto.constant.ValidationErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!DomainValidator.hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(ValidationErrorMessage.INVALID_SIZE.getErrorMessage());
        }

        for (int number : numbers) {
            if (!DomainValidator.hasCorrectRange(number)) {
                throw new IllegalArgumentException(ValidationErrorMessage.INVALID_RANGE.getErrorMessage());
            }
        }

        if (!DomainValidator.isAllUnique(numbers)) {
            throw new IllegalArgumentException(ValidationErrorMessage.DUPLICATE_NUMBERS.getErrorMessage());
        }
    }



    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
