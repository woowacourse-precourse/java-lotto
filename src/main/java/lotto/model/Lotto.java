package lotto.model;

import java.util.List;
import java.util.function.Consumer;

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
    }

    public void iterate(Consumer<Integer> consumer) {
        numbers.forEach(consumer);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
