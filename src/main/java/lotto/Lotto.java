package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            return false;
        }
        return true;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers, Integer number) {
        if (Collections.frequency(numbers, number) != 1) {
            return true;
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
