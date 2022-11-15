package lotto.model;

import lotto.constants.ErrorMessage;

import java.util.Collections;
import java.util.List;

import static lotto.constants.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR+ERROR_MESSAGE_SIZE);
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1){
                throw new IllegalArgumentException(ERROR + ERROR_MESSAGE_DUPLICATE
                );
            }
        }
    }
    public List<Integer> getLotto() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
