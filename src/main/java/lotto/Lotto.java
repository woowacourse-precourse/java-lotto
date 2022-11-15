package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static Constants.Constant.*;
import static Constants.Error.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLength(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
    }

    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> numbersNotDuplicate = new HashSet<>();
        numbersNotDuplicate.addAll(numbers);
        if (numbersNotDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (Collections.min(numbers) < 1 || Collections.max(numbers) > 45) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
