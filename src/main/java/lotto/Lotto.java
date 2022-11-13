package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.I_O_System.BAGIC_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        check_duplicate_numbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);

        }
    }

    // TODO: 추가 기능 구현
    private void check_duplicate_numbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (Collections.frequency(numbers, numbers.get(i)) != 1)
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);
        }
    }

}
