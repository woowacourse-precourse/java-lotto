package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isSixNumbers(numbers) || isDuplicated(numbers) || isInRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private boolean isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            return true;
        }
        return false;
    }
    private boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> NOT_DUPLICATED_NUMBERS = new HashSet<>();
        for (int i : numbers) {
            NOT_DUPLICATED_NUMBERS.add(i);
        }
        if (NOT_DUPLICATED_NUMBERS.size() != 6) {
            return true;
        }
        return false;
    }

    private boolean isInRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i < 1 || i > 45) {
                return true;
            }
        }
        return false;
    }
}
