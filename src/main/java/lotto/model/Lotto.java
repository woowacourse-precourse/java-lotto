package lotto.model;

import java.util.HashSet;
import java.util.List;

import static lotto.config.Constants.LottoNumber.*;
import static lotto.exception.LottoException.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);

        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBER_COUNT_MISMATCH.getErrorMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (!numbers.stream().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(n -> n >= LOTTO_NUMBER_START_INCLUSIVE && n <= LOTTO_NUMBER_END_INCLUSIVE)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
