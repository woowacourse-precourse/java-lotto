package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void checkOverlap(List<Integer> numbers) {
        int prev = 0;
        for (int i = 0; i < 6; i++) {
            if (prev == numbers.get(i)) {
                throw new IllegalArgumentException();
            }
            prev = numbers.get(i);
        }
    }
}
