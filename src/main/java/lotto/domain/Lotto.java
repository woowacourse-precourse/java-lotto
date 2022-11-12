package lotto.domain;

import java.util.List;

import static lotto.config.BaseValidation.INVALID_LOTTO;
import static lotto.config.Constant.LOTTO_NUMBER_CAPACITY;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != LOTTO_NUMBER_CAPACITY) {
            System.out.println(INVALID_LOTTO.getMessage());
            throw new IllegalArgumentException();
        }

    }

    public List<Integer> getLotto() {
        return numbers;
    }

}
