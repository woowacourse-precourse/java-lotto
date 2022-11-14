package lotto.domain;

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

        List<Integer> checkNumbers = new ArrayList<>();
        for (Integer i : numbers) {
            if (checkNumbers.contains(i)) {
                throw new IllegalArgumentException();
            }
            checkNumbers.add(i);
        }
    }
}
