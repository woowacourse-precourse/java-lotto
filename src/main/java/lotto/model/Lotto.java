package lotto.model;

import lotto.validation.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateSize(numbers, 6);
        Validator.validateNonDuplicatedList(numbers);
        Validator.validateNumbersRange(numbers, 1,45);
    }

}
