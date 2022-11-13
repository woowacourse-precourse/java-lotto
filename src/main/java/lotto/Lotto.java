package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!checkSize(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!checkDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!checkRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private boolean checkSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() == 6;
    }

    private boolean checkRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number >= 1)
                .filter(number -> number <= 46)
                .count() == 6;
    }
}
