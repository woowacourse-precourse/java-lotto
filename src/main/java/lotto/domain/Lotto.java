package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int FIX_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private boolean validateNumbersSize(List<Integer> numbers) {
        return numbers.size() != FIX_SIZE;
    }
}
