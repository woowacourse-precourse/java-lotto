package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.numberCountValidation(numbers);
        Validation.numberRangeValidation(numbers);
    }

    // TODO: 추가 기능 구현
}
