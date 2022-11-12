package lotto.domain;

import lotto.domain.io.DuplicationValidator;
import lotto.domain.io.NumberLengthValidator;
import lotto.domain.io.RangeValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberLengthValidator numberLengthValidator = new NumberLengthValidator();
        RangeValidator rangeValidator = new RangeValidator();
        DuplicationValidator duplicationValidator = new DuplicationValidator();

        numberLengthValidator.validate(numbers);
        rangeValidator.validate(numbers);
        duplicationValidator.validate(numbers);
    }
}
