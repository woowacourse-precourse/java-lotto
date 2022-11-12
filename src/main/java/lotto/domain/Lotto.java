package lotto.domain;

import java.util.List;

import static lotto.config.BaseValidation.*;
import static lotto.config.Constant.LOTTO_NUMBER_CAPACITY;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != LOTTO_NUMBER_CAPACITY) {
            System.out.println(OVER_CAPACITY_LOTTO.getMessage());
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < LOTTO_NUMBER_CAPACITY - 1;i++) {
            if (numbers.get(i) == numbers.get(i + 1)) {
                throw new IllegalArgumentException(DUPLICATION_NUMBER_LOTTO.getMessage());
            }
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

}
