package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateElementRange(numbers);
    }

    private void validateElementRange(List<Integer> numbers) {
        numbers.forEach(i -> {
            if(isOutOfRange(i)) {
                throw new IllegalArgumentException();
            }
        });
    }

    private boolean isOutOfRange(Integer value) {
        return value < 1 || value > 45;
    }
}
