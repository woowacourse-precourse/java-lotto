package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateOverlap(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> removeOverlap = new HashSet<>(numbers);
        if (numbers.size() != removeOverlap.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

}
