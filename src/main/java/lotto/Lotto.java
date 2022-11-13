package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    public boolean isExistNumber(int number) {
        return numbers.contains(number);
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();

        validator.validateNumberSize(numbers);
        validator.validateDuplicateNumber(numbers);
        validator.validateNumberRange(numbers);
    }
}
