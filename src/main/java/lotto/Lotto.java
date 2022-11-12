package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final int LOTTO_NUMBER = 6;
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidLotto(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Integer::compare);
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER;
    }

    private boolean isNotDuplicated(List<Integer> numbers) {
        return Set.of(numbers).size() == LOTTO_NUMBER;
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(v -> LOTTO_MIN <= v && v <= LOTTO_MAX);
    }

    private boolean isValidLotto(List<Integer> numbers) {
        return isCorrectSize(numbers) && isInRange(numbers) && isNotDuplicated(numbers);
    }
    // TODO: 추가 기능 구현
}
