package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        boolean anyMatch = numbers.stream()
                .anyMatch(number -> (number < 1 || number > 45));
        if (anyMatch) {
            throw new IllegalArgumentException();
        }
    }
}
