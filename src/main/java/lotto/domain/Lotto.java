package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;

public class Lotto {
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateUnique(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자가 필요합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }

    protected void validateRange(int number) {
        if (number > MAX_RANGE || number < MIN_RANGE) {
            throw new IllegalArgumentException("1부터 45까지의 숫자만 허용됩니다.");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> deduplication = new HashSet<>(numbers);
        if (deduplication.size() != 6) {
            throw new IllegalArgumentException("숫자가 모두 달라야합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
