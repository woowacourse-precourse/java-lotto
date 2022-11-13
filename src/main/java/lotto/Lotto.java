package lotto;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> getNumbers() {
        List<Integer> copyNumbers = new ArrayList<>();
        for (int n : numbers) copyNumbers.add(n);
        return copyNumbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
