package lotto.domain.entity;

import static lotto.domain.message.ExceptionMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.message.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        lottoNumberRangeCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_CODE + LOTTO_NUMBERS_SIZE_OUT_OF_RANGE_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != duplicatedNumbers.size()) {
            throw new IllegalArgumentException(ERROR_CODE + LOTTO_NUMBERS_DUPLICATE_MESSAGE);
        }
    }

    private void lottoNumberRangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_CODE + LOTTO_NUMBERS_OUT_OF_VALUE_MESSAGE);
            }
        }
    }
}
