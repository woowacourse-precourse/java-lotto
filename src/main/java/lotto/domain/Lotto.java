package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    Message message = null;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        checkOverRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(message.ERROR_MESSAGE_OVER_SIZE_LOTTO.getMessage());
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(message.ERROR_MESSAGE_DUPLICATION_LOTTO.getMessage());
        }
    }

    private void checkOverRange(List<Integer> numbers) {
        for (int numbersValue : numbers) {
            if (numbersValue > 45 || numbersValue < 1) {
                throw new IllegalArgumentException(message.ERROR_MESSAGE_OVER_RANGE_LOTTO.getMessage());
            }
        }
    }
}
