package lotto.machine;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.checkSize(numbers);
        Validator.checkUniqueness(numbers);
        numbers.forEach(number -> {
            Validator.checkRange(number);
        });
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
