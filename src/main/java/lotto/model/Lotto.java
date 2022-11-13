package lotto.model;

import java.util.List;
import lotto.ErrorControl;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        ErrorControl.validate(numbers);
        ErrorControl.validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
