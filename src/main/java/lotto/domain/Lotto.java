package lotto.domain;

import java.util.List;

import static lotto.config.BaseValidation.INVALID_LOTTO;

public class Lotto {

    private final List<Integer> numbers;
    private static final int LOTTO_NUMBER_CAPACITY = 6;

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
