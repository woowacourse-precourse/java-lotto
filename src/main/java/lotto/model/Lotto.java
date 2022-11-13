package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        int numbersLength = (int) numbers.stream()
                .distinct()
                .count();
        if (numbersLength != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }


}
