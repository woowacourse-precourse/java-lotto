package lotto;

import java.util.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidationUtil.isValidCount(numbers);
        ValidationUtil.isValidNumber(numbers);
        ValidationUtil.hasDistinctNumbers(numbers);
    }
}
