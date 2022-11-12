package lotto.model;

import java.util.List;
import lotto.ErrorControl;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ErrorControl errorControl = new ErrorControl();
        errorControl.validate(numbers);
        errorControl.validateDuplicateNumber(numbers);
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
