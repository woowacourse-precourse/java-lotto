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

        checkDuplicate(numbers);
    }

    private void checkDuplicate(List<Integer> numbers) {
        long numbersCount = numbers.stream().distinct().count();
        if (numbersCount != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return numbers.toString();
    }
}
