package lotto.game.domain;

import static lotto.game.ExceptionHandler.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throwException(NOT_SIX_NUMBER_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long noDuplicateCount = numbers.stream()
                .distinct()
                .count();
        if (noDuplicateCount != 6) {
            throwException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
