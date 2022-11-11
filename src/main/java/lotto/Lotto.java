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
        if(isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
