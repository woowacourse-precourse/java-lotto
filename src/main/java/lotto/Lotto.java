package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        List<Integer> numbersToBeValidated = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbersToBeValidated.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().allMatch(number -> number < 1 && number > 45 );
        if (isOutOfRange) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
