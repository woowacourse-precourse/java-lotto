package lotto.domain;

import lotto.utils.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.checkNumberLength(numbers);
        Validation.checkNumberRange(numbers);
        Validation.checkDuplicatedNumber(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
