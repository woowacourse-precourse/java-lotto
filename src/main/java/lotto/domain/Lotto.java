package lotto.domain;

import lotto.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
