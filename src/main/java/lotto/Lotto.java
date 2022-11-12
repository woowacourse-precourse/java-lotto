package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(GameConstant.SIZE_EXCEPTION.getValue());
        }

        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException(GameConstant.DUPLICATE_EXCEPTION.getValue());
        }
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        for (int element : numbers) {
            if (Collections.frequency(numbers, element) != 1) {
                return true;
            }
        }

        return false;
    }

}
