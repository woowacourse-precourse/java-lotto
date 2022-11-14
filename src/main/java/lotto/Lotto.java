package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

}
