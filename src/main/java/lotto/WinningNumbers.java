package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        checkScope(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOverlap(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        validate(distinctNumbers);
    }

    public void checkScope(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
