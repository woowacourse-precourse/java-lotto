package lotto.domain;

import lotto.validation.LottoValidation;

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
        LottoValidation.isValidLotto(numbers);
    }

    // TODO: 추가 기능 구현
}
