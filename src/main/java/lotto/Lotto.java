package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOutOfRange(numbers);
        checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOutOfRange(List<Integer> numbers) {
        if (numbers.get(0) < 1 || numbers.get(numbers.size() - 1) > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException();
        }
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}