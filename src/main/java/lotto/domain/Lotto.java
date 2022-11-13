package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateEachNumberInRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEachNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }
}