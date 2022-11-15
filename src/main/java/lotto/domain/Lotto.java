package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.sizeCheck(numbers);
        Validator.duplicationCheck(numbers);
        Validator.rangeCheck(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
