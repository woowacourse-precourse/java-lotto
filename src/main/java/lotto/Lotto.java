package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasSameNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void hasSameNumber(List<Integer> numbers) {
        Set<Integer> sameNumber = new HashSet<>(numbers);
        if (sameNumber.size() != 6) {
            throw new IllegalArgumentException();
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
