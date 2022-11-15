package lotto.domain;

import lotto.service.Validate;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final Validate validate = new Validate();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validate.IsDuplicatedNumber(numbers);
        validate.IsOverLengthNumber(numbers);
        validate.IsCorrectRangeNumber(numbers);
        validate.IsSortedNumbers(numbers);
    }

    // TODO: 추가 기능 구현
}
