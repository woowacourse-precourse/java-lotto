package lotto;

import java.util.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Util.isValidCount(numbers);
        Util.isValidNumber(numbers);
        Util.hasDistinctNumbers(numbers);
    }

    private static Lotto create() {
        return new Lotto(Util.createRandomNumbers());
    }
}
