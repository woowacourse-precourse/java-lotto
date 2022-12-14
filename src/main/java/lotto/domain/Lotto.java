package lotto.domain;

import java.util.List;
import lotto.message.ErrorMessage;

public class Lotto {
    public static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER_ERROR);
        }
        if (isOutOfBound(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUNDS_LOTTO_NUMBER_ERROR);
        }
    }

    private boolean isDuplicated(final List<Integer> numbers) {
        return LOTTO_COUNT == numbers.stream()
                .distinct()
                .count();
    }

    private boolean isOutOfBound(final List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).get() <= 45
                && numbers.stream().min(Integer::compareTo).get() >= 1;
    }
}
