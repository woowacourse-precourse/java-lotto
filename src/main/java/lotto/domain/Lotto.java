package lotto.domain;

import java.util.List;
import java.util.TreeSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = deDuplicationAndSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> deDuplicationAndSort(List<Integer> numbers) {
        if (deDuplicationAndSort(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
        return List.copyOf(new TreeSet<Integer>(numbers));
    }

    public List<Integer> get() {
        return numbers;
    }
}
