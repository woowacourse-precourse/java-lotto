package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        isSixNumbers(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.IS_NOT_SIX.getMessage());
        }
    }

}
