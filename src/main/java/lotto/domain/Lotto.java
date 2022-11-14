package lotto.domain;

import lotto.validation.LottoValidation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidation lottoValidation = new LottoValidation();
        lottoValidation.validate(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() { return numbers; }
}
