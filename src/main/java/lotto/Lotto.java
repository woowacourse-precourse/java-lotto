package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateElementRange(numbers);
    }

    private void validateElementRange(List<Integer> numbers) {
        numbers.forEach(i -> {
            if(isOutOfRange(i)) {
                throw new IllegalArgumentException();
            }
        });
    }

    private boolean isOutOfRange(Integer value) {
        return value < 1 || value > 45;
    }
}
