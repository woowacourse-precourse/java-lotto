package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDistinct(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.NOT_VALIDATE_LENGTH.getMessage());
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Error.NOT_DISTINCT.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        Integer maxNumber = 45;
        Integer minNumber = 1;

        for (Integer number : numbers) {
            if (maxNumber.compareTo(number) == 1 || minNumber.compareTo(number) == -1) {
                throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
            }
        }
    }
}
