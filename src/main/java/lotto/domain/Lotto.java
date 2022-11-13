package lotto.domain;

import java.util.List;

import static lotto.constant.Message.DUPLICATE_LOTTO_NUMBER_MESSAGE;
import static lotto.constant.Message.INVALID_LOTTO_NUMBER_SIZE_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();
        if (count < 6) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_MESSAGE);
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
}
