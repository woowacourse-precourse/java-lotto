package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.ErrorCode.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        List<Integer> check = new ArrayList<>();
        for (int number : numbers) {
            if (check.contains(number)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
            }
            check.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
