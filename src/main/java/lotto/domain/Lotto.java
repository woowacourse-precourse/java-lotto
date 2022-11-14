package lotto.domain;

import lotto.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.GameConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateLength(numbers, LOTTO_NUMBERS_LENGTH);
        Validator.validateRange(numbers, LOTTO_NUMBERS_LENGTH);
        Validator.validateDuplication(numbers, LOTTO_NUMBERS_LENGTH);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
