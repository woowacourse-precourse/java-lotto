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
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private boolean checkSize() {
        return numbers.size() == 6;
    }

    private boolean checkDuplicate() {
        return numbers.stream().distinct().count() != 6;
    }

    private boolean checkRange() {
        return numbers.stream()
                .filter(number -> number >= 1)
                .filter(number -> number <= 46)
                .count() == 6;
    }
}
