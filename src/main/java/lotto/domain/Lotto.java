package lotto.domain;

import java.util.List;

import static lotto.validation.LottoValidation.checkValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkValidation(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
