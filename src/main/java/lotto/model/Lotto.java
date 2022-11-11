package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumRange(numbers);
        validateNumOverlap(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumOverlap(List<Integer> numbers) {
        Set<Integer> numberCollect = numbers.stream().collect(Collectors.toSet());
        if (numbers.size() != numberCollect.size()) {
            throw new IllegalArgumentException();
        }
    }
}
