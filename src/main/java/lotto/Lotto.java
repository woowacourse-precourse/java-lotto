package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_QUANTITY.get());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> checkDuplication = new HashSet<>(numbers);
        if (numbers.size() != checkDuplication.size()) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_DUPLICATED.get());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if ((number < 1) || (number > 45)) {
                throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_RANGE.get());
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
