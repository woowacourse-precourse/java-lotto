package lotto.lotteryshop;

import lotto.validator.ValueValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValueValidator.validateInputLottoNumber(numbers);
    }
}
