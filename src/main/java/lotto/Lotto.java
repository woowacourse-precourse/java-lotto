package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> hash_numbers = new HashSet<>(numbers);
        if (numbers.size() != 6) throw new IllegalArgumentException();
        if (hash_numbers.size() != 6) throw new IllegalArgumentException();
    }
}
