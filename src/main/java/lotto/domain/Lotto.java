package lotto.domain;

import lotto.validation.LottoValidation;

import java.util.List;

public class Lotto {
    private static final LottoValidation lottoValidation = new LottoValidation();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoValidation.numberCountCheck(numbers);
        lottoValidation.numberDuplicateCheck(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
