package lotto.domain;

import lotto.LottoValidation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validLotto(numbers);
        this.numbers = numbers;
    }

    private void validLotto(List<Integer> numbers) {
        LottoValidation.validateLottoSize(numbers);
        LottoValidation.validLottoNumberDuplicate(numbers);
        LottoValidation.validNumberRange(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
