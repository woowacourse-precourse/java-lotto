package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> checkError = new HashSet<>(numbers);
        checkError.retainAll(numbers);
        if (checkError.size() != numbers.size())
            throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
