package lotto;

import lotto.domain.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.inRange(numbers);
        Validation.noDuplication(numbers);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
