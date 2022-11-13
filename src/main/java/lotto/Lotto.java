package lotto;

import java.util.List;

import lotto.validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateNumberCountIsSix(numbers);
        LottoNumberValidator.validateIsInLottoRange(numbers);
        LottoNumberValidator.validateHasNoDuplication(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
