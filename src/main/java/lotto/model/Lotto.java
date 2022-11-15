package lotto.model;

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
        Set<Integer> checkSet = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (checkSet.size() != numbers.size())
            throw new IllegalArgumentException();
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
}
