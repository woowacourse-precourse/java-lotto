package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    private final int LOTTO_NUMBER = 6;
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidLotto(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    //로또의 유효성 검사
    private boolean isValidLotto(List<Integer> numbers) {
        return isCorrectSize(numbers) && isInRange(numbers) && isNotDuplicated(numbers);
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER;
    }

    private boolean isNotDuplicated(List<Integer> numbers) {
        return Set.copyOf(numbers).size() == LOTTO_NUMBER;
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(v -> LOTTO_MIN <= v && v <= LOTTO_MAX);
    }
}
