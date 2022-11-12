package lotto.domain;

import lotto.ui.Error;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.MUST_BE_SIX_DIGIT);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Error.HAD_DUPLICATE_NUMBER);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(Error.MUST_BE_NUMBERS_BETWEEN_1_TO_45);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
