package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
