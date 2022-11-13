package lotto.domain;

import lotto.domain.validator.LottoNumbersValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean containsThisNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        LottoNumbersValidator.validateLottoNumbers(numbers);
    }

    // TODO: 로또 번호 꺼내기
}
