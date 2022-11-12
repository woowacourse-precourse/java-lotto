package lotto.domain;

import static lotto.domain.constant.IntValueConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_NUMBER_OF_DIGITS;
import static lotto.exception.ExceptionHandler.ILLEGAL_RANGE;
import static lotto.exception.ExceptionHandler.INPUT_SIX_DIGITS;
import static lotto.exception.ExceptionHandler.OVERLAP_NUMBER;

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
        validateRangeNumbers(numbers);
        validateOverlapNumbers(numbers);

        if (numbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            INPUT_SIX_DIGITS.error();
        }
    }

    private void validateRangeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MINIMUM_NUMBER.getValue() || number > LOTTO_MAXIMUM_NUMBER.getValue()) {
                ILLEGAL_RANGE.error();
            }
        }
    }

    private void validateOverlapNumbers(List<Integer> numbers) {
        Set<Integer> pickedUniqueNumbersInRange = new HashSet<>(numbers);

        if (pickedUniqueNumbersInRange.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            OVERLAP_NUMBER.error();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}