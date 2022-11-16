package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String ERROR_MESSAGE_NUMBER_DUPLICATE = "[ERROR] 각 숫자는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateNotDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT);
        }
    }
    private void validateNotDuplicate(List<Integer> numbers) {
        HashSet set = new HashSet();
        set.addAll(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_DUPLICATE);
        }
    }
    // TODO: 추가 기능 구현
}
