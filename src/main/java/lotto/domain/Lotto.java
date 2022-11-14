package lotto.domain;

import java.util.List;

public class Lotto extends Valid {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        isCorrectSize(numbers);
        isCorrectRange(numbers);
        isNoDuplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
