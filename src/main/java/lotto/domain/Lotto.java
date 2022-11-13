package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.ExceptionConstants.*;
import static lotto.constant.LottoConstants.*;

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
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_EXCEPTION.toString());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (LOTTO_NUMBER_LENGTH != numbers.stream()
                .filter(number -> MIN_NUMBER <= number)
                .filter(number -> number <= MAX_NUMBER)
                .count()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION.toString());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (LOTTO_NUMBER_LENGTH != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_EXCEPTION.toString());
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
