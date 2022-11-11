package lotto.model;


import static lotto.validator.LottoNumberValidator.hasValidLotteryNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        hasValidLotteryNumber(numbers);
    }

    // TODO: 추가 기능 구현
}
