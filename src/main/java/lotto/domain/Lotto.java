package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validate(numbers);
    }

    public List<Integer> returnLottoNumbers(){
        return numbers;
    }
}
