package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_QUANTITY.get());
        }

        Set<Integer> checkDuplication = new HashSet<>(numbers);
        if (numbers.size() != checkDuplication.size()) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_DUPLICATED.get());
        }

        for (int i = 0; i < numbers.size(); i++) {
            if ((numbers.get(i) < 0) || (numbers.get(i) > 45)) {
                throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_RANGE.get());
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
