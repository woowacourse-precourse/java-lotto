package lotto.domain;

import lotto.domain.constant.LottoProperty;
import lotto.constant.ValidationErrorMessage;

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
        if (!hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(ValidationErrorMessage.INVALID_SIZE.getErrorMessage());
        }

        for (int number : numbers) {
            if (!hasCorrectRange(number)) {
                throw new IllegalArgumentException(ValidationErrorMessage.INVALID_RANGE.getErrorMessage());
            }
        }

        if (!isAllUnique(numbers)) {
            throw new IllegalArgumentException(ValidationErrorMessage.DUPLICATE_NUMBERS.getErrorMessage());
        }
    }

    private boolean hasCorrectSize (List<Integer> numbers) {
        return numbers.size() == LottoProperty.LENGTH.getProperty();
    }

    private boolean hasCorrectRange (int number) {
        return (number >= LottoProperty.MIN_NUMBER.getProperty())
                && (number <= LottoProperty.MAX_NUMBER.getProperty());
    }

    private boolean isAllUnique (List<Integer> numbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(numbers);
        return lottoNumberSet.size() == LottoProperty.LENGTH.getProperty();
    }
}
