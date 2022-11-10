package lotto.domain;

import java.util.List;
import java.util.TreeSet;

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
        if (deleteDuplicated(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> deleteDuplicated(List<Integer> numbers) {
        return List.copyOf(new TreeSet<Integer>(numbers));
    }

    public List<Integer> get() {
        return numbers;
    }
}
