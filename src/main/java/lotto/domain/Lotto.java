package lotto.domain;

import lotto.validator.InputValidator;

import java.util.List;

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
        InputValidator.validateLottoSize(numbers);
        numbers.forEach(InputValidator::validateNumberRange);
        InputValidator.validateOverlappingNumbers(numbers);
    }
}
