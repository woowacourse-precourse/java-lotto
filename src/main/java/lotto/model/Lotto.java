package lotto.model;

import static lotto.constant.LottoConstants.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSize(numbers);
        hasDuplicateNumber(numbers);
    }

    private void isValidSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MSG);
        }
    }

    private void hasDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST_MSG);
        }
    }
    // TODO: 추가 기능 구현
}
