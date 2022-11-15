package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Error.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkSize(numbers);
        checkRange(numbers);
        checkDuplicated(numbers);
        this.numbers = numbers;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getMessage());
            }
        }
    }

    private void checkDuplicated(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
