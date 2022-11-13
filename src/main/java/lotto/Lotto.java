package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateCorrectRange(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numset = new HashSet<>(numbers);

        if (numbers.size() != numset.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCorrectRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
