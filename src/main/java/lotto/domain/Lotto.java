package lotto.domain;

import lotto.util.GenerationUtil;
import lotto.util.ValidationUtil;

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

    public static Lotto create() {
        return new Lotto(GenerationUtil.generateRandomNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String printNumbers() {
        List<Integer> numbers = getNumbers();
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (Integer number : numbers) {
            stringJoiner.add(String.valueOf(number));
        }
        return stringJoiner.toString();
    }
}
