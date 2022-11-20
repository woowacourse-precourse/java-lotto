package lotto.domain;

import static lotto.exception.ErrorMessage.*;

import java.util.List;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NOT_SIX_NUMBER.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void checkLotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean hasDuplicationNumber = numbers.stream()
                .distinct()
                .count() != numbers.size();
        if (hasDuplicationNumber) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
