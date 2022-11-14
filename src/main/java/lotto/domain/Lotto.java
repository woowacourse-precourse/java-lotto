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
        ValidationUtil.isValidWinNumbers(numbers);
    }

    public static Lotto create() {
        return new Lotto(GenerationUtil.generateRandomNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String printNumbers() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        List<Integer> numbers = new ArrayList<>(getNumbers());
        Collections.sort(numbers);
        for (Integer number : numbers) {
            stringJoiner.add(String.valueOf(number));
        }
        return stringJoiner.toString();
    }
}
