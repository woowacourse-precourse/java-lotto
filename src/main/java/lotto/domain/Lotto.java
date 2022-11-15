package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberLength(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);

        this.numbers = numbers;
    }

    private void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
            }
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR);
            }
        }
    }
}
