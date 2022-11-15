package lotto.domain.lotto;

import lotto.utils.ErrorCode;

import java.util.List;

import static lotto.domain.lotto.LottoConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_SIZE.getMessage());
        }

        if (!isUnique(numbers)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }

        if (outOfRange(numbers) > 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_RANGE.getMessage());
        }
    }

    private long outOfRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(this::isInvalidRange)
                .count();
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE.getNumber();
    }

    private boolean isUnique(List<Integer> numbers) {
        return numbers.stream().distinct().count() == LOTTO_SIZE.getNumber();
    }

    private boolean isInvalidRange(Integer number) {
        return number < LOTTO_MIN_VALUE.getNumber() || number > LOTTO_MAX_VALUE.getNumber();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
