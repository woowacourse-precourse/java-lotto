package lotto.domain;

import java.util.Collections;
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
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void sortNumberAscending() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
