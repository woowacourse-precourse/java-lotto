package lotto.model;

import static lotto.validator.LottoNumberValidator.hasValidLotteryNumber;

import java.util.Collections;
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

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
