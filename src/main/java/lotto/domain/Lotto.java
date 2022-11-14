package lotto.domain;

import java.util.List;

import static lotto.constant.ConstValue.*;
import static lotto.constant.Message.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateNumbersSize(numbers);
    }


    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();
        if (count < 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }


    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }
}
