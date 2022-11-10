package lotto.domain;

import lotto.util.Util;

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

    public static Lotto create() {
        return new Lotto(Util.createRandomNumbers());
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
