package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
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
}
