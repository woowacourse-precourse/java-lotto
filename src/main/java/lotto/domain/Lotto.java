package lotto.domain;

import java.util.List;

import static lotto.constant.ConstValue.*;
import static lotto.constant.Message.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);

        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();
        if (count < 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        int count = (int) numbers.stream()
                .filter(number -> number >= LOTTO_NUMBER_MINIMUM)
                .filter(number -> number <= LOTTO_NUMBER_MAXIMUM)
                .count();

        if (count != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_NUMBER_INPUT_FORMAT_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
